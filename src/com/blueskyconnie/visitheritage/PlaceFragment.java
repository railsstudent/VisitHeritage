package com.blueskyconnie.visitheritage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.helper.FavoritePlaceHolder;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.helper.QRCodeHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class PlaceFragment extends BaseFragment {

	private static final String TAG = "AroundMeListAdapter";
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;

	private Place currentPlace;
	private VisitHeritageState state;
	private FavoritePlaceHolder favoriteHolder;
	
	private TextView tvName;
	private TextView tvAddress;
	private TextView tvHour;
	private TextView tvDescription;
	private TextView tvHomePage;
	private TextView tvPhone;
	private TextView tvEmail;
	private TextView tvRemark;
	private ImageView imgPlace;
	private TextView tvLocation;
	private Bitmap qrBitmap;
	private ImageView imgQRCode;

	private ImageLoader imageLoader = ImageLoader.getInstance();
	
	public PlaceFragment() {
		// not a top level fragment
		super(false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu_place, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.item_favorite:
				String msg = "";
				// update favorite id set 
				if (favoriteHolder.isFavorite(currentPlace.getId())) {
					// remove from favorite
					favoriteHolder.removeFavorite(currentPlace.getId());
				  	msg = getResources().getString(R.string.article_remove_from_favorites);
				} else {
					favoriteHolder.addFavorite(currentPlace.getId());
				  	msg = getResources().getString(R.string.article_add_to_favorites);
				}
				Crouton.makeText(getActivity(), msg, Style.INFO).show();
				// invalidate menu to show different icon and text
				getActivity().supportInvalidateOptionsMenu();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		MenuItem itemFavorite = menu.findItem(R.id.item_favorite);
		if (favoriteHolder.isFavorite(currentPlace.getId())) {
			itemFavorite.setIcon(android.R.drawable.btn_star_big_on);
			itemFavorite.setTitle(R.string.menu_item_favorite);
		} else {
			itemFavorite.setIcon(android.R.drawable.btn_star_big_off);
			itemFavorite.setTitle(R.string.menu_item_unfavorite);
		}
		
		// show/hide favorite menu item
		boolean drawerOpen = ((MainActivity)getActivity()).isDrawerOpen();
		menu.findItem(R.id.item_favorite).setVisible(!drawerOpen);
		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onPause() {
		// release memory of qr code
		if (qrBitmap != null) {
			qrBitmap.recycle();
			qrBitmap = null;
		}
		
		// write favorite ids to share preference
		favoriteHolder.saveFavorites();
		super.onPause();
	}

	@SuppressLint("DefaultLocale")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        
       // Place place = null;
        if (getArguments() != null) {
        	Bundle bundle = getArguments();
        	currentPlace = bundle.getParcelable(Constants.PLACE_KEY);
        }
        
        tvName = (TextView) rootView.findViewById(R.id.tvName);
        tvAddress = (TextView) rootView.findViewById(R.id.tvAddress);
        tvHour = (TextView) rootView.findViewById(R.id.tvHour);
        tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        tvHomePage = (TextView) rootView.findViewById(R.id.tvHomepage);
        tvPhone = (TextView) rootView.findViewById(R.id.tvPhone);		
        tvEmail = (TextView) rootView.findViewById(R.id.tvEmail);
        tvRemark = (TextView) rootView.findViewById(R.id.tvRemark);
        imgPlace = (ImageView) rootView.findViewById(R.id.imgPlace);
        tvLocation = (TextView) rootView.findViewById(R.id.tvLocation);

        if (currentPlace != null) {
    		if (PlaceCursorHelper.IsDeviceEngLang()) {
    			tvName.setText(Strings.nullToEmpty(currentPlace.getName_en()));
    			tvAddress.setText(Strings.nullToEmpty(currentPlace.getAddress_en()));
    			tvHour.setText(Strings.nullToEmpty(currentPlace.getOpeningHour_en()));
    			tvDescription.setText(Strings.nullToEmpty(currentPlace.getDescription_en()));
    			tvRemark.setText(Strings.nullToEmpty(currentPlace.getRemark_en()));
    			tvLocation.setText(Strings.nullToEmpty(currentPlace.getLocation_en()));
    		} else {
    			tvName.setText(Strings.nullToEmpty(currentPlace.getName()));
    			tvAddress.setText(Strings.nullToEmpty(currentPlace.getAddress()));
    			tvHour.setText(Strings.nullToEmpty(currentPlace.getOpeningHour()));
    			tvDescription.setText(Strings.nullToEmpty(currentPlace.getDescription()));
    			tvRemark.setText(Strings.nullToEmpty(currentPlace.getRemark()));
    			tvLocation.setText(Strings.nullToEmpty(currentPlace.getLocation()));
    		}
    		
    		String homepageUrl = PlaceCursorHelper.getUrlByLanguage(currentPlace.getHomepage());
			tvHomePage.setText(homepageUrl);
			tvEmail.setText(Strings.nullToEmpty(currentPlace.getEmail()));
			tvPhone.setText(Strings.nullToEmpty(currentPlace.getPhone()));
			Linkify.addLinks(tvPhone, Linkify.PHONE_NUMBERS);
			
			imgQRCode = (ImageView) rootView.findViewById(R.id.imgQRCode);
			
			if (!Strings.isNullOrEmpty(currentPlace.getUrl())) {
	    		imageLoader.displayImage(PlaceCursorHelper.getUrlByLanguage(currentPlace.getUrl()), 
	    				imgPlace, new SimpleImageLoadingListener(){
					@Override
					public void onLoadingFailed(String imageUri, View view,
							FailReason failReason) {
						super.onLoadingFailed(imageUri, view, failReason);
						switch (failReason.getType()) {
							case IO_ERROR:
								Log.e(TAG, "Input/Output error");
								break;
							case DECODING_ERROR:
								Log.e(TAG, "Image can't be decoded");
								break;
							case NETWORK_DENIED:
								Log.e(TAG, "Downloads are denied");
								break;
							case OUT_OF_MEMORY:
								Log.e(TAG, "Out Of Memory error");
								break;
							case UNKNOWN:
								Log.e(TAG, "Unknown error");
								break;
						}
					}
	        	});
        	}	
        }
        return rootView;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//state = ((MainActivity) getActivity()).getState();
		state = ((VisitHeritageApplication) getActivity().getApplicationContext()).getState();
		favoriteHolder = state.getFavorites();
	}

	@Override
	public void onResume() {
		super.onResume();
		String homepageUrl = PlaceCursorHelper.getUrlByLanguage(currentPlace.getHomepage());
		qrBitmap = QRCodeHelper.generateCode(getActivity(), homepageUrl, WIDTH, HEIGHT);
		imgQRCode.setImageBitmap(qrBitmap);
		imgQRCode.setVisibility(qrBitmap == null ? View.INVISIBLE : View.VISIBLE);
	}
}
