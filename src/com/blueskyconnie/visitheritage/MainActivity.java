package com.blueskyconnie.visitheritage;

import java.util.ArrayList;
import java.util.List;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blueskyconnie.visitheritage.adapter.NavDrawerListAdapter;
import com.blueskyconnie.visitheritage.model.NavDrawerItem;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends ActionBarActivity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private String appPath = "";
	private String appUrl = "";

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private List<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	private VisitHeritageState state;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();

		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		for (int i = 0; i < navMenuTitles.length; i++) {
			// adding nav drawer items to array
			navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuIcons
					.getResourceId(i, -1)));
		}
		navMenuIcons.recycle();

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(this, R.layout.drawer_list_item,
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				supportInvalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				supportInvalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		if (savedInstanceState == null) {
			// on first time display home screen
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.frame_container, new HomeFragment(),
							Constants.HOME_TAG).commit();
		}

		//state = new VisitHeritageState(this);
		appPath = "market://details?id=" + getPackageName();
		appUrl = "http://play.google.com/store/apps/details?id=" + getPackageName();

		state = ((VisitHeritageApplication) this.getApplicationContext()).getState();
		String strProximity = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("key_around_me_distance", "1000");
		int intProximity = 0;
		try {
			intProximity = Integer.parseInt(strProximity); 
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			intProximity = 1000;
		}
		state.setAround_me_distance(intProximity);
		this.mDrawerLayout.openDrawer(Gravity.LEFT);
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		String tagname = "";

		switch (position) {
		case 0:
			fragment = new ChooseAreaFragment();
			tagname = Constants.CHOOSE_AREA_TAG;
			break;
		case 1:
			fragment = new AroundMeFragment();
			tagname = Constants.AROUND_ME_TAG;
			break;
		case 2:
			fragment = new FavoriteFragment();
			tagname = Constants.FAVORITE_TAG;
			break;
		case 3:
			// Notes To Visitor
			fragment = new VisitorFragment();
			tagname = Constants.VISITOR_TAG;
			break;
		case 4:
			// contact us
			fragment = new ContactUsFragment();
			tagname = Constants.CONTACT_TAG;
			break;
		case 5:
			// rate my app
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(appPath));
			Log.i(TAG, "Rate My App path - " + appPath);
			startActivity(intent);
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();

			// clear all fragments in backstack
			Fragment currentFragment = fragmentManager
					.findFragmentById(R.id.frame_container);
			currentFragment.getFragmentManager().popBackStack(null,
					FragmentManager.POP_BACK_STACK_INCLUSIVE);

			fragmentManager.beginTransaction()
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
					.replace(R.id.frame_container, fragment, tagname).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e(TAG, "Error in creating fragment");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		// Handle action bar actions click
		switch (item.getItemId()) {
			case R.id.item_clear_disc_cache:
				imageLoader.clearDiscCache();
				Log.i(TAG, "Clear memory from disc");
				return true;
			case R.id.item_clear_memory_cache:
				imageLoader.clearMemoryCache();
				Log.i(TAG, "Clear memory from memory");
				return true;
			case R.id.item_share:
				Log.i(TAG, "Tell a friend about application");
				createShareIntent();
				return true;
				// launch information activity
			case R.id.item_info:
				Log.i(TAG, "Show information activity");
				startActivity(new Intent(this, SettingActivity.class));
				return true;
			case R.id.item_settings:
				Log.i(TAG, "Show preference activity");
				startActivity(new Intent(this, AppPreferenceActivity.class));
				return true;
		}
		return false;
	}

	private void createShareIntent() {

		// http://stackoverflow.com/questions/10922762/open-link-of-google-play-store-in-mobile-version-android
		Intent intent = new Intent(Intent.ACTION_SEND);
		// intent.setType("text/plain");
		intent.setType("message/rfc882");
		intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
		intent.putExtra(Intent.EXTRA_TEXT,
				String.format(getString(R.string.body), appUrl));
		try {
			startActivity(Intent.createChooser(intent,
					getString(R.string.share_app)));
		} catch (ActivityNotFoundException ex) {
			Crouton.makeText(this, R.string.app_not_found, Style.ALERT).show();
		}
	}

	/***
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.item_clear_disc_cache).setVisible(!drawerOpen);
		menu.findItem(R.id.item_clear_memory_cache).setVisible(!drawerOpen);
		menu.findItem(R.id.item_share).setVisible(!drawerOpen);
		menu.findItem(R.id.item_info).setVisible(!drawerOpen);
		menu.findItem(R.id.item_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggle
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {

		// See bug:
		// http://stackoverflow.com/questions/13418436/android-4-2-back-stack-behaviour-with-nested-fragments/14030872#14030872
		// If the fragment exists and has some back-stack entry
		FragmentManager fm = this.getSupportFragmentManager();
		Fragment currentFragment = fm.findFragmentById(R.id.frame_container);
		if (currentFragment != null && currentFragment instanceof FragmentLevel) {
			// Fragment baseFragment = (BaseFragment) currentFragment;
			String tagname = currentFragment.getTag();
			if (((FragmentLevel) currentFragment).isTopFragment()) {
				if (!Constants.HOME_TAG.equals(tagname)) {
					fm.beginTransaction()
							.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
							.replace(R.id.frame_container, new HomeFragment(),
									Constants.HOME_TAG).commit();
					return;
				}
			}
			super.onBackPressed();
		} else {
			super.onBackPressed();
		}
	}

	// //
	// http://stackoverflow.com/questions/7137742/simpleongesturelistener-not-working-for-scrollview
	// @Override
	// public boolean dispatchTouchEvent(MotionEvent event) {
	// // find current fragment
	// FragmentManager fm = this.getSupportFragmentManager();
	// Fragment currentFragment = fm.findFragmentById(R.id.frame_container);
	// if (currentFragment != null &&
	// Constants.CONTACT_TAG.equals(currentFragment.getTag())) {
	// ((ContactUsFragment)
	// currentFragment).getGestureDetector().onTouchEvent(event);
	// }
	// return super.dispatchTouchEvent(event);
	// }

	@Override
	protected void onDestroy() {
		Crouton.cancelAllCroutons();
		super.onDestroy();
	}

//	public VisitHeritageState getState() {
//		return state;
//	}

	// expose a method to click item in nav drawer item
	public void selectItem(int position) {
		// get the navigation drawer item
		mDrawerList.performItemClick(mDrawerList, position,
				mDrawerList.getItemIdAtPosition(position));
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout.isDrawerOpen(mDrawerList);
	}

}
