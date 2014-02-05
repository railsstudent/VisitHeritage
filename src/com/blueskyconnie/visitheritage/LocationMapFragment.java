package com.blueskyconnie.visitheritage;


import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.common.base.Strings;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
 
public class LocationMapFragment extends BaseFragment {

	private static final String SHARE_PREF_NAME = "pref_marker";
	private static final int RQS_GooglePlayServices = 1;
	
	private MapView mapView;
	private List<Place> lstPlace;
	private GoogleMap map;
	private SparseArray<Place> hmNamePlace;
	private String language;
	private String region_key = "";
	private int pref_placeId;
	private SparseArray<Marker> markerArray;
	
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
			setHasOptionsMenu(true);
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

		lstPlace = getArguments().getParcelableArrayList(Constants.PLACES);
		hmNamePlace = new SparseArray<Place>();
		if (lstPlace != null) {
			for (Place place : lstPlace) {
				hmNamePlace.put(place.getId(), place);
			}
		}
		markerArray = new SparseArray<Marker>();
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		try {
			super.onActivityCreated(savedInstanceState);
			if (mapView != null) {
				mapView.onCreate(savedInstanceState);
			}
			// check current language of the device
	 		language = Locale.getDefault().getLanguage();
	 		
	 		// get the region that is being displayed in fragment
	 		region_key = getArguments().getString(Constants.REGION_KEY);
			if (Strings.isNullOrEmpty(region_key)) {
				region_key = Constants.SHARE_PREF_HK;
			}
		} catch (Exception ex) {
			Crouton.makeText(getActivity(), "onActivityCreated: " + ex.getMessage(), Style.ALERT).show();
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
		savePreference();
		if (mapView != null) {
			mapView.onPause();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		// add markers on the map
		try {
			int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
			if (resultCode == ConnectionResult.SUCCESS) {
				if (mapView != null) { 
					map = mapView.getMap();
					if (map != null) {
						// remove all markers in the fragment
						map.clear();
						markerArray.clear();

	                     map.setOnMarkerClickListener(markerClickListener);
	                     map.setOnInfoWindowClickListener(infoWinClickListener);
	                     
	                     // show a custom information marker
	                     map.setInfoWindowAdapter(new PlaceInfoWindowAdapter());
	                     
	                     map.animateCamera(CameraUpdateFactory.zoomTo(14));
	                     map.setMyLocationEnabled(true);

	                 	if (lstPlace != null) {
	                    	 LatLng latlng = null;
	                    	 int lastPlaceId = -1;
	                    	 
		                     // 1) loop the lstPlace list 
		              	     // 1a)  create markeroption, set title, snippet and icon, and add to map  
		                     for (Place place : lstPlace) {
		                    	latlng = new LatLng(place.getLat(), place.getLng());
		                    	lastPlaceId = place.getId();
		                        Marker marker = map.addMarker(new MarkerOptions().position(latlng)
		                                 .title(String.valueOf(place.getId()))
		                                 .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_red)));
		                        markerArray.put(lastPlaceId, marker);
		                     }
		                     try {
	
			                 	 // load the marker from shared preference
			                     loadPreference(lastPlaceId);
		                     } catch (Exception ex1) {
		             			 Crouton.makeText(getActivity(), "onResume: loadPreference error. " + ex1.getMessage(),
	            					Style.ALERT).show();	                    	 
		                     }
	                 	} 
					}
					mapView.onResume();				
				}
			} else {
				 GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), RQS_GooglePlayServices).show();
			}
		} catch (Exception ex) {
			Crouton.makeText(getActivity(), "onResume: unknown exception captured.",
					Style.ALERT).show();
		}
	}
		
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu_location, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_legalnotices) {
			String LicenseInfo = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
			AlertDialog.Builder LicenseDialog = new AlertDialog.Builder(getActivity());
   		    LicenseDialog.setTitle(getString(R.string.menu_legalnotices));
			LicenseDialog.setMessage(LicenseInfo);
			LicenseDialog.show();
			return true;
		} 	
		return super.onOptionsItemSelected(item);
	}
	
	private OnMarkerClickListener markerClickListener = new OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
       	 	 // update shared preference
       	     if (!Strings.isNullOrEmpty(marker.getTitle())) {
       	    	 pref_placeId = Integer.parseInt(marker.getTitle());
       	    	 savePreference();
       	     }
                marker.showInfoWindow();
                return false;
        }
	};

	private OnInfoWindowClickListener infoWinClickListener = new OnInfoWindowClickListener(){

		public void onInfoWindowClick(Marker marker) {
			// open place fragment
			int placeId = -1;
        	String strId = Strings.nullToEmpty(marker.getTitle());
        	placeId = Integer.parseInt(strId);
        	Place place = hmNamePlace.get(placeId, null);
        	if (place != null) {
        		// update shared preference 
        		pref_placeId = placeId;
        		savePreference();
        		
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.PLACE_KEY, place);
				PlaceFragment fragment = new PlaceFragment();
				fragment.setArguments(bundle);
				FragmentManager fragManager = LocationMapFragment.this.getFragmentManager();
				fragManager.beginTransaction()
					.replace(R.id.frame_container, fragment)
					.addToBackStack(null)
					.commit();
			} else {
				Crouton.makeText(LocationMapFragment.this.getActivity(), 
						getResources().getString(R.string.no_monument_errmsg),
						Style.ALERT).show();
			}
		}
     };
	
	
	private final class PlaceInfoWindowAdapter implements InfoWindowAdapter /*, View.OnClickListener*/ {

        @Override
        public View getInfoContents(Marker marker) {
        	
        	String err_msg = getResources().getString(R.string.no_monument_errmsg);

            try {
            	String not_avail = getResources().getString(R.string.not_avail);
            	String name = not_avail;
            	String address = not_avail;
            	String location = not_avail;
            	int placeId = -1;
                
            	String strId = Strings.nullToEmpty(marker.getTitle());
            	placeId = Integer.parseInt(strId);
            	Place place = hmNamePlace.get(placeId, null);
            	if (place != null) {
            		// check current language of the device
             		if (Constants.LANG_CODE_EN.equals(Strings.nullToEmpty(language).toUpperCase(Locale.getDefault()))) {
             			name = Strings.nullToEmpty(place.getName_en()); // English Name
             			address = Strings.nullToEmpty(place.getAddress_en()); // English Address
             			location = Strings.nullToEmpty(place.getLocation_en()); // English Location
             		} else {
             			name = Strings.nullToEmpty(place.getName()); // Chinese Name 
             			address = Strings.nullToEmpty(place.getAddress()); // Chinese Address
             			location = Strings.nullToEmpty(place.getLocation()); // English Location
             		}
             		
             		// 1) Inflate the view 
            	    // 2) call view.findViewById to get textview, imageview, button, etc
            	    // 2a)  set text of textview
            	    // 2b)  set onclick listener to button. When button is clicked, another fragment is shown 
            	    LayoutInflater inflater =  getActivity().getLayoutInflater();
            	    View view = inflater.inflate(R.layout.layout_infomarker, null);
            	    TextView tvInfoName = (TextView) view.findViewById(R.id.tvInfoName);
            	    TextView tvInfoAddress = (TextView) view.findViewById(R.id.tvInfoAddress);
            	    TextView tvInfoLocation = (TextView) view.findViewById(R.id.tvInfoLocation);
            	    tvInfoName.setText(getResources().getString(R.string.lblName) + name);
            	    tvInfoAddress.setText(getResources().getString(R.string.lblAddress) +address);
            	    tvInfoLocation.setText(getResources().getString(R.string.lblLocation) + location);
                    return view;
            	} else {
            		Crouton.makeText(LocationMapFragment.this.getActivity(), err_msg, Style.ALERT).show();
            	}
            } catch (NumberFormatException ex) {
        		Crouton.makeText(LocationMapFragment.this.getActivity(), err_msg, Style.ALERT).show();
            }
    	    return null;
        }

        @Override
        public View getInfoWindow(Marker marker) {
           return null;
        }
	}
	
	private void loadPreference(int defaultPlaceId) {
		// load the marker from shared preference
        SharedPreferences pref = getActivity().getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        pref_placeId = pref.getInt(region_key, defaultPlaceId);
        if (pref_placeId > -1) {
           Place sharedPrefPlace = hmNamePlace.get(pref_placeId);
           if (sharedPrefPlace == null) {
               pref_placeId = defaultPlaceId;
               sharedPrefPlace = hmNamePlace.get(pref_placeId);
           }
           if (sharedPrefPlace != null) {
               // update shared preference 
               pref.edit().putInt(region_key, pref_placeId).commit();
        	   // open marker window
	           if (markerClickListener != null) {
	       		   Marker marker = markerArray.get(pref_placeId, null);
	       		   if (marker != null) {
	       			   markerClickListener.onMarkerClick(marker);
	       		   }
	       	   }
	           LatLng latlng = new LatLng(sharedPrefPlace.getLat(), sharedPrefPlace.getLng());
	       	   map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
	           map.animateCamera(CameraUpdateFactory.zoomTo(14));
           } 
        }
	}
	
	private void savePreference() {
		// load the marker from shared preference
        SharedPreferences pref = getActivity().getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
 		// update shared preference 
       	pref.edit().putInt(region_key, pref_placeId).commit();
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = ((MainActivity)getActivity()).isDrawerOpen();
		menu.findItem(R.id.menu_legalnotices).setVisible(!drawerOpen);
		super.onPrepareOptionsMenu(menu);
	}
	
	
}
