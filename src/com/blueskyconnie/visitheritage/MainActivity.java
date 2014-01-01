package com.blueskyconnie.visitheritage;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blueskyconnie.visitheritage.adapter.NavDrawerListAdapter;
import com.blueskyconnie.visitheritage.model.NavDrawerItem;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends  FragmentActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private ImageLoader imageLoader = ImageLoader.getInstance();

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private List<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

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

		getActionBar().setDisplayHomeAsUpEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		 if (savedInstanceState == null) {
			 // on first time display home screen
			 getSupportFragmentManager()
			 	.beginTransaction()
			 	.replace(R.id.frame_container, new HomeFragment(), Constant.HOME_TAG)
			 	.commit();
		 }
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
//			    fragment = new FindPeopleFragment();
//			    tagname = Constant.PEOPLE_TAG;
			    break;
		 	case 1:
//  			    fragment = new PhotosFragment();
//			    tagname = Constant.PHOTO_TAG;
			    break;
			case 2:
				 // Notes To Visitor
				 fragment = new VisitorFragment();
				 tagname = Constant.VISITOR_TAG;
				 break;
			case 3:
//				 // contact us
				 fragment = new ContactUsFragment();
				 tagname = Constant.CONTACT_TAG;
				 break;
			case 4:
				 // rate my app 
				String path = "market://details?id=" + getPackageName();
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
				Log.i("MainActivity", "Rate My App path - " + path);
				 startActivity(intent);
				 break;
			default:
				break;
		 }
	
		 if (fragment != null) {
			 FragmentManager fragmentManager = getSupportFragmentManager();
			 fragmentManager.beginTransaction()
			 .replace(R.id.frame_container, fragment, tagname)
			 .commit();
		
			 // update selected item and title, then close the drawer
			 mDrawerList.setItemChecked(position, true);
			 mDrawerList.setSelection(position);
			 setTitle(navMenuTitles[position]);
			 mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			 // error in creating fragment
			 Log.e("MainActivity", "Error in creating fragment");
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
				Log.i("MainActivity", "Clear memory from disc");
				return true;
			case R.id.item_clear_memory_cache:
				imageLoader.clearMemoryCache();
				Log.i("MainActivity", "Clear memory from memory");
				return true;
			case R.id.item_about:
				Log.i("MainActivity", "Show About Dialog");
				return true;
		}
		return false;
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
  	    menu.findItem(R.id.item_about).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
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
		 //http://stackoverflow.com/questions/13418436/android-4-2-back-stack-behaviour-with-nested-fragments/14030872#14030872
		 // If the fragment exists and has some back-stack entry
		 FragmentManager fm = this.getSupportFragmentManager();
		 Fragment currentFragment = fm.findFragmentById(R.id.frame_container);
		 if (currentFragment != null && currentFragment instanceof BaseFragment) {
			 BaseFragment baseFragment = (BaseFragment) currentFragment;
			 String tagname = baseFragment.getTag();
			 if (baseFragment.isTopFragment()) {
				 if (!Constant.HOME_TAG.equals(tagname)) {
					 fm.beginTransaction().replace(R.id.frame_container, new HomeFragment(),
							 Constant.HOME_TAG)
							 .commit();
					 return;
				 } else {
					 // Home fragment. Remove all fragments in the backstack, so
					 // super.onBackPressed will simply exit
					 if (currentFragment.getFragmentManager().getBackStackEntryCount() > 0) {
						 	currentFragment.getFragmentManager().popBackStack(null,
						 			FragmentManager.POP_BACK_STACK_INCLUSIVE);
					 }
				 }
			 }
			 super.onBackPressed();
		 } else {
			 super.onBackPressed();
		 }
	 }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	// http://stackoverflow.com/questions/7137742/simpleongesturelistener-not-working-for-scrollview
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// find current fragment
		FragmentManager fm = this.getSupportFragmentManager();
  	    Fragment currentFragment = fm.findFragmentById(R.id.frame_container);
		if (currentFragment != null && Constant.CONTACT_TAG.equals(currentFragment.getTag())) {
			((ContactUsFragment) currentFragment).getGestureDetector().onTouchEvent(event);
		}
		return super.dispatchTouchEvent(event);
	}
}
