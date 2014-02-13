package com.blueskyconnie.visitheritage.adapter;

import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.Constants;
import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class FavoriteListAdapter extends ArrayAdapter<Place> {

	private static final String TAG = "AroundMeListAdapter";
	
	private Context context;
	private int resourceId;
	private List<Place> lstPlace;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private String strLat = "";
	private String strLng = "";
	private String strLocation = "";
	
	public FavoriteListAdapter(Context context, int resourceId, List<Place> lstPlace) {
		super(context, resourceId, lstPlace);
		this.context = context;
		this.resourceId = resourceId;
		this.lstPlace = lstPlace;
		
		strLat = context.getString(R.string.strLat);
		strLng = context.getString(R.string.strLng);
		strLocation = context.getString(R.string.lblLocation);
	}

	@Override
	public int getCount() {
		return lstPlace.size();
	}

	@Override
	public Place getItem(int position) {
		return lstPlace.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).hashCode();
	}

	@SuppressLint("DefaultLocale")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		FavoriteHolder holder = null;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resourceId, null);
			holder = new FavoriteHolder();
			holder.tvName = (TextView) view.findViewById(R.id.tvName);
			holder.tvLat = (TextView) view.findViewById(R.id.tvLat);
			holder.tvLng = (TextView) view.findViewById(R.id.tvLng);
			holder.img = (ImageView) view.findViewById(R.id.imgPlaceThumbnail);
			holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
			holder.tvLocation = (TextView) view.findViewById(R.id.tvLocation);
			view.setTag(holder);
		} else {
			holder = (FavoriteHolder) view.getTag();
		}

		Place place = getItem(position);
		String name = "";
		String location = "";
		// check current language of the device
		Locale locale = Locale.getDefault();
		String language = locale.getLanguage();
		
		String deviceLang = Strings.nullToEmpty(language).toUpperCase(locale);
		if (Constants.LANG_CODE_EN.equals(deviceLang)) {
			name = Strings.nullToEmpty(place.getName_en()); // English
			location = Strings.nullToEmpty(place.getLocation_en());
		} else {
			name = Strings.nullToEmpty(place.getName()); // Chinese Name 
			location = Strings.nullToEmpty(place.getLocation());
		}
		
		holder.tvCount.setText(String.valueOf((position + 1) + ")"));
		holder.tvName.setText(name);
		holder.tvLat.setText(strLat + " " + String.valueOf(place.getLat())); 
		holder.tvLng.setText(strLng + " " + String.valueOf(place.getLng()));
		holder.tvLocation.setText(strLocation + " " + location);
		
		if (holder.img != null && !Strings.isNullOrEmpty(place.getUrl())) {
			imageLoader.displayImage(PlaceCursorHelper.getUrlByLanguage(place.getUrl(), deviceLang), holder.img, 
					new SimpleImageLoadingListener() {
							@Override
							public void onLoadingFailed(String imageUri,
									View view, FailReason failReason) {
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
		return view;
	}
	
	private static class FavoriteHolder {
		TextView tvName;
		TextView tvLat;
		TextView tvLng;
		ImageView img;
		TextView tvCount;
		TextView tvLocation;
	}
}
