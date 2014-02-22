package com.blueskyconnie.visitheritage;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SplashActivity extends Activity {

	private static class SplashHandler extends Handler {

		private static final int DELAY_MILLISECONDS = 2000;

		private final WeakReference<SplashActivity> activity;
		
		public SplashHandler(SplashActivity activity) {
			this.activity = new WeakReference<SplashActivity>(activity);
		}
		
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (activity.get() != null) {
				// http://stackoverflow.com/questions/19516224/android-black-screen-is-coming-after-splash-screen
				// start another thread to wait a few second and launch main activity
				final Handler handler = new Handler();
				handler.postDelayed(
						new Runnable() {
							@Override
							public void run() {
								Intent intent = new Intent(activity.get(), MainActivity.class);
								activity.get().startActivity(intent);
								activity.get().finish();
								handler.removeCallbacks(this);
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
			mImgView.setScaleType(ScaleType.FIT_XY);
			anim.start();
				
			new Thread(new MyRunnable(mHandlerPreload, this)).start();
		}
	}
	
	private static class MyRunnable implements Runnable {

		private SplashHandler handler;
		
		MyRunnable (SplashHandler handler, SplashActivity splashActivity) {
			this.handler = handler;
		}
		
		@Override
		public void run() {
			Message msg = handler.obtainMessage();
			handler.sendMessage(msg);
		}
	}
}
