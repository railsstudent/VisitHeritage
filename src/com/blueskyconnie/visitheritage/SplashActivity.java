package com.blueskyconnie.visitheritage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.blueskyconnie.visitheritage.dao.PlaceDao;
import com.blueskyconnie.visitheritage.model.Place;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class SplashActivity extends Activity {

	private static class SplashHandler extends Handler {

		private static final int DELAY_MILLISECONDS = 2000;
		private final WeakReference<SplashActivity> activity;
		
		private ArrayList<Place> lstHK;
		private ArrayList<Place> lstKowloon;
		private ArrayList<Place> lstNT;
		private ArrayList<Place> lstIsland;
		
		public SplashHandler(SplashActivity activity) {
			this.activity = new WeakReference<SplashActivity>(activity);
		}
		
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (activity.get() != null) {
				
				Bundle bundle = msg.getData();
				if (bundle != null) {
					lstHK = bundle.getParcelableArrayList(Constants.HK_KEY);
					lstKowloon = bundle.getParcelableArrayList(Constants.KOWLOON_KEY);
					lstNT = bundle.getParcelableArrayList(Constants.NT_KEY);
					lstIsland = bundle.getParcelableArrayList(Constants.ISLAND_KEY);
				}
				
				if (lstHK == null) {
					lstHK = new ArrayList<Place>();
				} 
				if (lstKowloon == null) {
					lstKowloon = new ArrayList<Place>();
				}
				if (lstNT == null) {
					lstNT = new ArrayList<Place>();
				}
				if (lstIsland == null) {
					lstIsland = new ArrayList<Place>();
				}
				
				// start another thread to wait a few second and launch main activity
				new Handler().postDelayed(
						new Runnable() {
							@Override
							public void run() {
								Intent intent = new Intent(activity.get(), MainActivity.class);
								intent.putParcelableArrayListExtra(Constants.HK_KEY, lstHK);
								intent.putParcelableArrayListExtra(Constants.KOWLOON_KEY, lstKowloon);
								intent.putParcelableArrayListExtra(Constants.NT_KEY, lstNT);
								intent.putParcelableArrayListExtra(Constants.ISLAND_KEY, lstIsland);
								// launch MainActivity and finish this Activity.
								// So backpress does not return to this screen
								activity.get().startActivity(intent);
								activity.get().finish();
							}
						}, DELAY_MILLISECONDS);
			}
		}
	}
	
	private SplashHandler mHandlerPreload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			setContentView(R.layout.activity_splash);
			mHandlerPreload = new SplashHandler(this); 	
			
			AnimationDrawable anim = (AnimationDrawable) 
			getResources().getDrawable(R.drawable.anim_activity_main_preload);
	
			ImageView mImgView = (ImageView) findViewById(R.id.imgSplash);
			mImgView. setImageDrawable(anim);
			anim.start();
				
			new Thread(new MyRunnable(mHandlerPreload, this)).start();
		}
	}
	
	private static class MyRunnable implements Runnable {

		private WeakReference<SplashActivity> activity;
		private SplashHandler handler;
		
		MyRunnable (SplashHandler handler, SplashActivity splashActivity) {
			this.handler = handler;
			this.activity = new WeakReference<SplashActivity>(splashActivity);
		}
		
		@Override
		public void run() {
			
			// retrieve data from sqlite 
			PlaceDao dao = null; 
			ArrayList<Place> lstHK = new ArrayList<Place>();
			ArrayList<Place> lstKowloon = new ArrayList<Place>();
			ArrayList<Place> lstNT = new ArrayList<Place>();
			ArrayList<Place> lstIsland = new ArrayList<Place>();
			
			try {
				dao = new PlaceDao(activity.get());
				dao.open();  // damn, forgot to open db
				lstHK = (ArrayList <Place>) dao.getHKPlaces();
				lstKowloon = (ArrayList <Place>) dao.getKowloonPlaces();
				lstNT = (ArrayList <Place>) dao.getNTPlaces();
				lstIsland = (ArrayList <Place>) dao.getIslandPlaces();
			} catch (SQLException ex) {
				Log.i("SplashActivity", ex.getLocalizedMessage());
				Crouton.makeText(activity.get(), ex.getMessage(), Style.ALERT);
			} finally {
				if (dao != null) {
					dao.close();
				}
			}

			// store in bundle and assign to instance variables of MainActivity
			Message msg = handler.obtainMessage();
			Bundle data = new Bundle();
			data.putParcelableArrayList(Constants.HK_KEY, lstHK);
			data.putParcelableArrayList(Constants.KOWLOON_KEY, lstKowloon);
			data.putParcelableArrayList(Constants.NT_KEY, lstNT);
			data.putParcelableArrayList(Constants.ISLAND_KEY, lstIsland);
			msg.setData(data);
			handler.sendMessage(msg);
		}
	}
}
