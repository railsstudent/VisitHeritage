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

import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.model.Place;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class AroundMeListAdapter extends ArrayAdapter<Place> {

	private Context context;
	private int resourceId;
	private List<Place> lstPlace;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	
	public AroundMeListAdapter(Context context, int resourceId, List<Place> lstPlace) {
		super(context, resourceId, lstPlace);
		this.context = context;
		this.resourceId = resourceId;
		this.lstPlace = lstPlace;
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
		
		AroundMeHolder holder = null;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resourceId, null);
			view.setTag(holder);
			holder = new AroundMeHolder();
			holder.tvName = (TextView) view.findViewById(R.id.tvName);
			holder.tvLat = (TextView) view.findViewById(R.id.tvLat);
			holder.tvLng = (TextView) view.findViewById(R.id.tvLng);
			holder.tvDistance = (TextView) view.findViewById(R.id.tvDistance);
			holder.img = (ImageView) view.findViewById(R.id.imgPlaceThumbnail);
		} else {
			holder = (AroundMeHolder) view.getTag();
		}

		Place place = getItem(position);
		String name = "";
		// check current language of the device
		Locale locale = Locale.getDefault();
		String language = locale.getDisplayLanguage();
		if ("EN".equals(Strings.nullToEmpty(language).toUpperCase(locale))) {
			name = Strings.nullToEmpty(place.getName()); // English
		} else {
			name = Strings.nullToEmpty(place.getName_en()); // Chinese Name 
		}
		holder.tvName.setText(name);
		holder.tvLat.setText(String.valueOf(place.getLat())); 
		holder.tvLng.setText(String.valueOf(place.getLng()));
		holder.tvDistance.setText(String.valueOf(place.getDistance()));
		if (holder.img != null && !Strings.isNullOrEmpty(place.getUrl())) {
			imageLoader.displayImage(place.getUrl(), holder.img, 
					new SimpleImageLoadingListener() {
							@Override
							public void onLoadingFailed(String imageUri,
									View view, FailReason failReason) {
								super.onLoadingFailed(imageUri, view, failReason);
								switch (failReason.getType()) {
									case IO_ERROR:
										Log.e("AroundMeAdapter", "Input/Output error");
										break;
									case DECODING_ERROR:
										Log.e("AroundMeAdapter", "Image can't be decoded");
										break;
									case NETWORK_DENIED:
										Log.e("AroundMeAdapter", "Downloads are denied");
										break;
									case OUT_OF_MEMORY:
										Log.e("AroundMeAdapter", "Out Of Memory error");
										break;
									case UNKNOWN:
										Log.e("AroundMeAdapter", "Unknown error");
										break;
								}
							}
					});
		}
		return view;
	}
	
	private static class AroundMeHolder {
		TextView tvName;
		TextView tvLat;
		TextView tvLng;
		TextView tvDistance;
		ImageView img;
	}
	
}
