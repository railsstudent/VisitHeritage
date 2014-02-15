package com.blueskyconnie.visitheritage.adapter;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.Constants;
import com.blueskyconnie.visitheritage.MainActivity;
import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.helper.FavoritePlaceHolder;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class AroundMeListAdapter extends ArrayAdapter<Place>  {

	private static final String TAG = "AroundMeListAdapter";
	
	private Context context;
	private int resourceId;
	private List<Place> lstPlace;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private String strLat = "";
	private String strLng = "";
	private String strMeter = "";
	private String strDistance = "";
	private String strLocation = "";
	
	//private VisitHeritageState state;
	private FavoritePlaceHolder favoriteHolder;
	
	public AroundMeListAdapter(Context context, int resourceId, List<Place> lstPlace, 
			VisitHeritageState state) {
		
		super(context, resourceId, lstPlace);
		this.context = context;
		this.resourceId = resourceId;
		this.lstPlace = lstPlace;
		
		strLat = context.getString(R.string.strLat);
		strLng = context.getString(R.string.strLng);
		strMeter = context.getString(R.string.strMeter);
		strDistance = context.getString(R.string.strDistance);
		strLocation = context.getString(R.string.lblLocation);
		favoriteHolder = state.getFavorites();
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

//	@Override
//	public int getItemViewType(int position) {
//		if (position == 0) {
//			// header
//			return HEADER;
//		} else {
//			// cell
//			return CELL;
//		}
//	}
//	
//	@Override
//	public int getViewTypeCount() {
//		return 2;
//	}

	@SuppressLint("DefaultLocale")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
//		// return header view
//		if (getItemViewType(position) == HEADER) {
//			if (convertView == null) {
//				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//				convertView = inflater.inflate(R.layout.layout_around_me_heading, null);
//				TextView tvHeader = (TextView) convertView.findViewById(R.id.tvHeader);
//				tvHeader.setText("");
//			}
//			return convertView;
//		}
		
		AroundMeHolder holder = null;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resourceId, null);
			holder = new AroundMeHolder();
			holder.tvName = (TextView) view.findViewById(R.id.tvName);
			holder.tvLat = (TextView) view.findViewById(R.id.tvLat);
			holder.tvLng = (TextView) view.findViewById(R.id.tvLng);
			holder.tvDistance = (TextView) view.findViewById(R.id.tvDistance);
			holder.img = (ImageView) view.findViewById(R.id.imgPlaceThumbnail);
			holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
			holder.tvLocation = (TextView) view.findViewById(R.id.tvLocation);
			holder.imgBtnFavorite = (ImageButton) view.findViewById(R.id.imgBtnFavorite);
			view.setTag(holder);
		} else {
			holder = (AroundMeHolder) view.getTag();
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
		holder.imgBtnFavorite.setOnClickListener(new AroundMeFavoriteListener(place, 
				new WeakReference<ImageButton>(holder.imgBtnFavorite)));
		// set icon image 
		holder.imgBtnFavorite.setImageResource(
				favoriteHolder.isFavorite(place.getId()) ? android.R.drawable.btn_star_big_on :
				android.R.drawable.btn_star_big_off);
		
		BigDecimal bdDist = new BigDecimal(place.getDistance(), MathContext.UNLIMITED);
		bdDist = bdDist.setScale(2, RoundingMode.HALF_DOWN);
		holder.tvDistance.setText(strDistance + " " + bdDist.toPlainString() + " " + strMeter);
		
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
	
	private static class AroundMeHolder {
		TextView tvName;
		TextView tvLat;
		TextView tvLng;
		TextView tvDistance;
		ImageView img;
		TextView tvCount;
		TextView tvLocation;
		ImageButton imgBtnFavorite;
	}
		
	private class AroundMeFavoriteListener implements View.OnClickListener {

		private Place currentPlace;
		private WeakReference<ImageButton> imgButton;
		
		AroundMeFavoriteListener(Place currentPlace, 
				WeakReference<ImageButton> imgButton) {
			
			this.currentPlace = currentPlace;
			this.imgButton = imgButton;
		}
		
		@Override
		public void onClick(View v) {
			String msg = "";
			// update favorite id set 
			if (favoriteHolder.isFavorite(currentPlace.getId())) {
				// remove from favorite
				favoriteHolder.removeFavorite(currentPlace.getId());
				if (imgButton.get() != null) {
					imgButton.get().setImageResource(android.R.drawable.btn_star_big_off);
				}
			  	msg = context.getResources().getString(R.string.article_remove_from_favorites);
			} else {
				favoriteHolder.addFavorite(currentPlace.getId());
				if (imgButton.get() != null) {
					imgButton.get().setImageResource(android.R.drawable.btn_star_big_on);
				}
				msg = context.getResources().getString(R.string.article_add_to_favorites);
			}
			Crouton.makeText(((MainActivity)context), msg, Style.INFO).show();
			favoriteHolder.saveFavorites();
		}
	}
}
