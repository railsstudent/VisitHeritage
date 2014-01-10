package com.blueskyconnie.visitheritage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.adapter.AroundMeListAdapter;
import com.blueskyconnie.visitheritage.helper.ConnectionDetector;
import com.blueskyconnie.visitheritage.helper.DistanceComparator;
import com.blueskyconnie.visitheritage.model.Place;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

// http://www.michenux.net/android-around-me-tutorial-974.html
public class AroundMeFragment extends BaseListFragment implements GooglePlayServicesClient.ConnectionCallbacks,
	GooglePlayServicesClient.OnConnectionFailedListener, 
	LocationListener, 
	LoaderManager.LoaderCallbacks<Cursor> {

	private static final int FIFTEEN_SEC = 15 * 1000;
	private static final int FIVE_MIN = 5 * 60 * 1000;
	private static final int DIST = 100;
	
	// google request code
	private static final int RQS_GOOGLE_CONNECT = 1;
	private static final int LOADER_ID = 0;
	
	private AroundMeListAdapter aroundmeListAdapter;
	private LocationClient mLocationClient;
	private LocationRequest mRequest;
	private Geocoder mGeocoder;
	private TextView tvHeader;
	private View headerView;
	
	public AroundMeFragment() {
		topFragment = true;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		aroundmeListAdapter = new AroundMeListAdapter(getActivity(), R.layout.list_item_aroundme, new ArrayList<Place>());
		mLocationClient = new LocationClient(getActivity(), this, this);
		
		// We don’t need a high accuracy 
		// so location updates are configured with a 
		// minimal delay of 15s, a minimal move of 50 
		// meters, and endly with a middle 
		// priority : PRIORITY_BALANCED_POWER_ACCURACY.
		mRequest = LocationRequest.create()
					.setInterval(FIFTEEN_SEC)
					.setFastestInterval(FIVE_MIN)
					.setSmallestDisplacement(DIST)  // in meter
					.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
		
		mGeocoder = new Geocoder(getActivity());
		// init loader
		getLoaderManager().initLoader(LOADER_ID, null, this);
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_around_me, container, false);
        headerView = View.inflate(getActivity(), R.layout.layout_around_me_heading, null);
        tvHeader = (TextView) headerView.findViewById(R.id.tvHeader);
        return rootView;
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        ListView lv = getListView();
        lv.setOnScrollListener(new PauseOnScrollListener(ImageLoader.getInstance(), false, true));
        lv.addHeaderView(headerView);
        setListAdapter(aroundmeListAdapter);
	}

	@Override
	public void onConnected(Bundle bundle) {
		mLocationClient.requestLocationUpdates(mRequest, this);
	}

	@Override
	public void onDisconnected() {
		mLocationClient.removeLocationUpdates(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mLocationClient.isConnected()) {
			mLocationClient.removeLocationUpdates(this);
			mLocationClient.disconnect();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
		if (resultCode == ConnectionResult.SUCCESS) {
			if (!mLocationClient.isConnected()) {
				mLocationClient.connect();
			}
		} else {
			GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), RQS_GOOGLE_CONNECT).show();
		}
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		Crouton.makeText(getActivity(),
                getString(R.string.error_connectionfailed),
                Style.ALERT).show();
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.i("INFO LOG", "AroundMeFragment - onLocationChanged, new location - " + location);

		// get current address
		try {
			ConnectionDetector connector = new ConnectionDetector(getActivity());
			if (connector.isConnectingToInternet()) {
				List<Address> addresses = mGeocoder.getFromLocation(location.getLatitude(), 
							location.getLongitude(), 1);
				if (addresses != null && addresses.size() > 0) {
					Address address = addresses.get(0);
					tvHeader.setText(address.getLocality());
				}
			} else {
				tvHeader.setText("(lat: " + location.getLatitude() + ", lng: " + location.getLongitude());
			}
			// fire location changed
		} catch (IOException e) {
			e.printStackTrace();
			Crouton.makeText(getActivity(), e.getMessage(), Style.ALERT).show();
		}
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		
		List<Place> places = new ArrayList<Place>();
//		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//            Place place = new Place();
//            place.setName(CursorUtils.getString(PlaceContentProvider.NAME_COLUMN, cursor));
//            place.setCountry(CursorUtils.getString(PlaceContentProvider.COUNTRY_COLUMN, cursor));
//            place.setImage(CursorUtils.getString(PlaceContentProvider.URL_COLUMN, cursor));
//            Location loc = new Location("database");
//            loc.setLatitude(CursorUtils.getDouble(PlaceContentProvider.LATITUDE_COLUMN, cursor));
//            loc.setLongitude(CursorUtils.getDouble(PlaceContentProvider.LONGITUDE_COLUMN, cursor));
//            place.setLocation(loc);
//            place.setDistance(loc.distanceTo(this.mCurrentLocation));
//            places.add(place);
 //       }
		Collections.sort(places, new DistanceComparator());
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
}
