package com.blueskyconnie.visitheritage;


import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.model.Place;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.common.base.Strings;
 
public class LocationMapFragment extends BaseFragment {

	private static final int RQS_GooglePlayServices = 1;
	private MapView mapView;
	private List<Place> lstPlace;
	private GoogleMap map;
	
	public LocationMapFragment() {
		// not a top level fragment
		super(false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			// initialize mapview 
			if (savedInstanceState == null) {
				MapsInitializer.initialize(getActivity());
			}
		} catch (GooglePlayServicesNotAvailableException e) {
			Log.e("LocationMapFragment", "onCreate - " + e.getMessage());
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = (View) inflater.inflate(R.layout.fragment_location, null);
		mapView = (MapView) rootView.findViewById(R.id.mapView);
	
		String placeKey = getArguments().getString(Constants.PLACE_KEY);
		TextView tvArea = (TextView) rootView.findViewById(R.id.tvArea);
		tvArea.setText(placeKey);

		lstPlace = getArguments().getParcelableArrayList(Constants.PLACES)  ; 
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (mapView != null) {
			mapView.onCreate(savedInstanceState);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mapView != null) {
			mapView.onDestroy();
		}
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		if (mapView != null) {
			mapView.onLowMemory();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mapView != null) {
			mapView.onPause();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		// add markers on the map
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
		if (resultCode == ConnectionResult.SUCCESS) {
			if (mapView != null) { 
				map = mapView.getMap();
				if (map != null) {
					// remove all markers in the fragment
					map.clear();

                     // check current language of the device
              		 Locale locale = Locale.getDefault();
              		 String language = locale.getLanguage();
              		 String name = "";
              		 String address = "";
                 	 LatLng latlng = null;
                     
                     // 1) loop the lstPlace list 
              	    // 1a)  create markeroption, set title, snippet and icon, and add to map  
                     for (Place place : lstPlace) {
                    	 latlng = new LatLng(place.getLat(), place.getLng());
                    	
                 		if (Constants.LANG_CODE_EN.equals(Strings.nullToEmpty(language).toUpperCase(locale))) {
                 			name = Strings.nullToEmpty(place.getName_en()); // English
                 			address = Strings.nullToEmpty(place.getAddress_en()); // English
                 		} else {
                 			name = Strings.nullToEmpty(place.getName()); // Chinese Name 
                 			address = Strings.nullToEmpty(place.getAddress()); // Chinese Address
                 		}
                        map.addMarker(new MarkerOptions().position(latlng)
                                 .title(name)
                                 .snippet(address)
                                 .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red)));
                     }
                     if (latlng != null) {
                    	 map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                     }
                     map.animateCamera(CameraUpdateFactory.zoomTo(14));
                     map.setMyLocationEnabled(true);
                                          
                     // open info marker when pin is clicked
                     map.setOnMarkerClickListener(new OnMarkerClickListener() {
                             @Override
                             public boolean onMarkerClick(Marker marker) {
                                     marker.showInfoWindow();
                                     return false;
                             }
                     });
                     
                     // show a custom information marker
                     map.setInfoWindowAdapter(new PlaceInfoWindowAdapter());
				}
				mapView.onResume();				
			}
		} else {
			 GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), RQS_GooglePlayServices).show();
		}
	}
		
	private final class PlaceInfoWindowAdapter implements InfoWindowAdapter {

		// @TODO: implement this button click listener
//		private OnClickListener listener = new OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				switch (view.getId()) {
//					case 1:
//						break;
//					default: 
//						break;
//				}
//			}
//		};
		
        @Override
        public View getInfoContents(Marker marker) {

//                String marker_title = marker.getTitle();
//                String marker_snippet = marker.getSnippet();
        	
//        		@TODO  implement this method
        	    // 1) Inflate the view 
        	    // 2) call view.findViewById to get textview, imageview, button, etc
        	    // 2a)  set text of textview
                // 2b)  use universal image loader to show image (may not do it if too hard)
        	    // 2c)  set onclick listener to button. When button is clicked, another fragment is shown 
//        	    LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
//        	    View view = inflater.inflate(1, null);
        	
        	    
                return null;
        }

        @Override
        public View getInfoWindow(Marker marker) {
                return null;
        }
}
	
}
