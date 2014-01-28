package com.blueskyconnie.visitheritage;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.model.Place;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class PlaceFragment extends BaseFragment {

	private static final String TAG = "AroundMeListAdapter";

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

	private ImageLoader imageLoader = ImageLoader.getInstance();
	
	public PlaceFragment() {
		// not a top level fragment
		super(false);
	}
	
	@SuppressLint("DefaultLocale")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        
        Place place = null;
        if (getArguments() != null) {
        	Bundle bundle = getArguments();
        	place = bundle.getParcelable(Constants.PLACE_KEY);
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

        if (place != null) {
        	
    		Locale locale = Locale.getDefault();
    		String language = locale.getLanguage();
    		
    		if (Constants.LANG_CODE_EN.equals(language.toUpperCase(Locale.getDefault()))) {
    			tvName.setText(Strings.nullToEmpty(place.getName_en()));
    			tvAddress.setText(Strings.nullToEmpty(place.getAddress_en()));
    			tvHour.setText(Strings.nullToEmpty(place.getOpeningHour_en()));
    			tvDescription.setText(Strings.nullToEmpty(place.getDescription_en()));
    			tvRemark.setText(Strings.nullToEmpty(place.getRemark_en()));
    			tvLocation.setText(Strings.nullToEmpty(place.getLocation_en()));
    		} else {
    			tvName.setText(Strings.nullToEmpty(place.getName()));
    			tvAddress.setText(Strings.nullToEmpty(place.getAddress()));
    			tvHour.setText(Strings.nullToEmpty(place.getOpeningHour()));
    			tvDescription.setText(Strings.nullToEmpty(place.getDescription()));
    			tvRemark.setText(Strings.nullToEmpty(place.getRemark()));
    			tvLocation.setText(Strings.nullToEmpty(place.getLocation()));
    		}
			tvHomePage.setText(Strings.nullToEmpty(place.getHomepage()));
			tvEmail.setText(Strings.nullToEmpty(place.getEmail()));
			tvPhone.setText(Strings.nullToEmpty(place.getPhone()));
			Linkify.addLinks(tvPhone, Linkify.PHONE_NUMBERS);
    		
			if (!Strings.isNullOrEmpty(place.getUrl())) {
	    		imageLoader.displayImage(place.getUrl(), imgPlace, new SimpleImageLoadingListener(){
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
}
