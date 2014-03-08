package com.blueskyconnie.visitheritage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.adapter.AroundMeListAdapter;
import com.blueskyconnie.visitheritage.contentprovider.PlaceContentProvider;
import com.blueskyconnie.visitheritage.helper.ConnectionDetector;
import com.blueskyconnie.visitheritage.helper.DistanceComparator;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.sqllite.PlaceSqliteOpenHelper;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;

// https://github.com/chrisbanes/ActionBar-PullToRefresh/blob/master/samples/actionbarcompat/src/uk/co/senab/actionbarpulltorefresh/samples/actionbarcompat/FragmentTabsActivity.java
// http://www.michenux.net/android-around-me-tutorial-974.html
public class AroundMeFragment extends BaseListFragment implements
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener, LocationListener,
		LoaderManager.LoaderCallbacks<Cursor> {

	private static final String TAG = AroundMeFragment.class.getSimpleName();
	
	private static final int FIFTEEN_SEC = 15 * 1000;
	private static final int FIVE_MIN = 5 * 60 * 1000;
	private static final int DIST = 100;
	//private static final double DIST_PROXIMITY = 2000;

	// google request code
	private static final int RQS_GOOGLE_CONNECT = 1;
	private static final int LOADER_ID = 1;

	private AroundMeListAdapter aroundmeListAdapter;
	private LocationClient mLocationClient;
	private LocationRequest mRequest;
	private Geocoder mGeocoder;
	private Location mCurrentLocation;

	private TextView tvHeader;
	private Activity activity;
	private boolean isItemClicked = false;
	private String strLat;
	private String strLng;
	private VisitHeritageState state;

	private DistanceComparator distanceComparator;
	private ConnectionDetector connectionDetector;
	private LocationManager manager;
	private AlertDialog dialog;
		
	public AroundMeFragment() {
		topFragment = true;
		distanceComparator = new DistanceComparator();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		activity = getActivity();
		mLocationClient = new LocationClient(activity, this, this);

		// We don’t need a high accuracy
		// so location updates are configured with a
		// minimal delay of 15s, a minimal move of 50
		// meters, and endly with a middle
		// priority : PRIORITY_BALANCED_POWER_ACCURACY.
		mRequest = LocationRequest.create().setInterval(FIFTEEN_SEC)
				.setFastestInterval(FIVE_MIN).setSmallestDisplacement(DIST) // in
																			// meter
				.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
		mGeocoder = new Geocoder(getActivity());
		
		// mod by Connie Leung, 2014-03-05
		manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
	}
	
	private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
				case DialogInterface.BUTTON_POSITIVE:
					startActivity (new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
					break;
				case DialogInterface.BUTTON_NEGATIVE:
					if (dialog != null) {
						dialog.dismiss();
					}
					break;
				default:
					break;
			}
			
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_around_me,
				container, false);
		tvHeader = (TextView) rootView.findViewById(R.id.tvHeader);
		strLat = getString(R.string.strLat);
		strLng = getString(R.string.strLng);
	
		dialog =  new AlertDialog.Builder(getActivity())
					.setIcon(R.drawable.ic_launcher)
					.setTitle(getString(R.string.enableGPS_title))
					.setCancelable(false)
					.setMessage(getString(R.string.askGPS))
					.setPositiveButton(getString(R.string.yesGPS), dialogListener)
					.setNegativeButton(getString(R.string.noGPS), dialogListener)
					.create();
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView lv = getListView();
		lv.setOnScrollListener(new PauseOnScrollListener(ImageLoader
				.getInstance(), false, true));
		aroundmeListAdapter = new AroundMeListAdapter(activity,
				R.layout.list_item_aroundme, new ArrayList<Place>(), 
				((VisitHeritageApplication) getActivity().getApplicationContext()).getState());
				//((MainActivity) getActivity()).getState());
		setListAdapter(aroundmeListAdapter);
		connectionDetector = new ConnectionDetector(getActivity());
		state = ((VisitHeritageApplication) getActivity().getApplicationContext()).getState();
	}

	@Override
	public void onConnected(Bundle bundle) {
		try {
			mLocationClient.requestLocationUpdates(mRequest, this);
			if (connectionDetector.isConnectingToInternet()) {
				if (mLocationClient.isConnected()) {
					mCurrentLocation = mLocationClient.getLastLocation();
					getLoaderManager().initLoader(LOADER_ID, null, this);
				}
			}
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
		}
	}

	@Override
	public void onDisconnected() {
		mLocationClient.removeLocationUpdates(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		if (connectionDetector.isConnectingToInternet()) {
			if (mLocationClient.isConnected()) {
				mLocationClient.removeLocationUpdates(this);
				mLocationClient.disconnect();
			}
		}
		
		if (dialog != null) {
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			dialog = null;
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		isItemClicked = false;
		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getActivity());
		if (resultCode == ConnectionResult.SUCCESS) {
			enableGPS();
			if (connectionDetector.isConnectingToInternet()) {
				if (!mLocationClient.isConnected()) {
					mLocationClient.connect();
				}
			}
		} else {
			GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(),
					RQS_GOOGLE_CONNECT).show();
		}
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		Log.e(TAG, getString(R.string.error_connectionfailed));
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.i(TAG, "AroundMeFragment - onLocationChanged, new location - " + location);

		// get current address
		try {
			if (location != null) {
				mCurrentLocation = location;
				if (connectionDetector.isConnectingToInternet()) {
					List<Address> addresses = mGeocoder.getFromLocation(
							location.getLatitude(), location.getLongitude(), 1);
					if (addresses != null && addresses.size() > 0) {
						Address address = addresses.get(0);
						tvHeader.setText(address.getCountryName());
					}
				} else {
					tvHeader.setText(strLat + location.getLatitude() 
							+ strLng + location.getLongitude());
				}
				// fire location changed, restart loader
				getLoaderManager().restartLoader(LOADER_ID, null, this);
			}
		} catch (IOException ex) {
			Log.e(TAG, ex.getMessage());
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
		}
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
		try {
			if (activity != null && mCurrentLocation != null) {
//				StringBuffer sbSort = new StringBuffer();
//				sbSort.append("abs( ");
//				sbSort.append(PlaceSqliteOpenHelper.COLUMN_LAT);
//				sbSort.append(" - ");
//				sbSort.append(mCurrentLocation.getLatitude());
//				sbSort.append(") + abs( ");
//				sbSort.append(PlaceSqliteOpenHelper.COLUMN_LNG);
//				sbSort.append(" - ");
//				sbSort.append(mCurrentLocation.getLongitude());
//				sbSort.append(") LIMIT 20 ");

				StringBuffer sbSort = new StringBuffer();
				sbSort.append("abs( ");
				sbSort.append(PlaceSqliteOpenHelper.COLUMN_LAT);
				sbSort.append(" - ");
				sbSort.append(mCurrentLocation.getLatitude());
				sbSort.append(") + abs( ");
				sbSort.append(PlaceSqliteOpenHelper.COLUMN_LNG);
				sbSort.append(" - ");
				sbSort.append(mCurrentLocation.getLongitude());
				sbSort.append(") ");
				List<Address> addresses = mGeocoder.getFromLocation(
						mCurrentLocation.getLatitude(),
						mCurrentLocation.getLongitude(), 1);
				if (addresses != null && addresses.size() > 0) {
					Address address = addresses.get(0);
					tvHeader.setText(address.getCountryName());
				}

				Uri uri = PlaceContentProvider.CONTENT_URI;
				CursorLoader cloader = new CursorLoader(activity, uri,
						PlaceSqliteOpenHelper.ALL_COLUMNS, null, null,
						sbSort.toString());
				return cloader;
			} else {
				return null;
			}
		} catch (Exception ex) {
			Log.i(TAG, ex.getMessage());
			return null;
		}
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

		List<Place> places = PlaceCursorHelper.loadFromCursor(cursor);
		for (Place place : places) {
			Location loc = new Location("database");
			loc.setLatitude(place.getLat());
			loc.setLongitude(place.getLng());
			place.setDistance(loc.distanceTo(mCurrentLocation));
		}
		Collection<Place> colPlaces = Collections2.filter(places, new Predicate<Place>() {
			@Override
			public boolean apply(Place place) {
				if (place == null) {
					return false;
				}
//				return place.getDistance() <= DIST_PROXIMITY;
				return place.getDistance() <= state.getAround_me_distance();
			}
		});
		places = new ArrayList<Place> (colPlaces);
		Collections.sort(places, distanceComparator);	
		onPlaceLoadFinished(places);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		onPlaceLoadFinished(new ArrayList<Place>());
	}

	private void onPlaceLoadFinished(List<Place> places) {
		aroundmeListAdapter.clear();
		for (Place place : places) {
			aroundmeListAdapter.add(place);
		}
		aroundmeListAdapter.notifyDataSetChanged();
	}

	@Override
	public void onListItemClick(ListView listView, View v, int position, long id) {
		if (!isItemClicked) {
			isItemClicked = true;
			// show place fragment
			Place place = (Place) listView.getItemAtPosition(position);
			if (place != null) {
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.PLACE_KEY, place);
				Fragment placeFragment = new PlaceFragment();
				placeFragment.setArguments(bundle);
				FragmentManager fragManager = this.getFragmentManager();
				fragManager.beginTransaction()
					.replace(R.id.frame_container, placeFragment)
					.addToBackStack(null)
					.commit();
			}  else {
				isItemClicked = false;
			}
		}
	}

	
	private void enableGPS() {
		if (manager == null) {
			manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
		}
		if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			// prompt user if he/she wants to have GPS enabled
			if (dialog != null) {
				dialog.show();
			}
		}
	}
}
