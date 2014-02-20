package com.blueskyconnie.visitheritage.adapter;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

//public class FavoriteListAdapter extends ArrayAdapter<Place>  {
public class FavoriteListAdapter extends BaseAdapter implements Filterable {

	private static final String TAG = FavoriteListAdapter.class.getSimpleName();
	private static final int NUM_LOAD_ELEMENTS = 3;
	
	private Context context;
	private int resourceId;
	private List<Place> lstPlace;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private FavoriteFilter favoriteFilter;
	private List<Place> lstOrigPlace;
	private int size;
	private Locale locale;
	
	public FavoriteListAdapter(Context context, int resourceId, List<Place> lstPlace) {
		//super(context, resourceId, lstPlace);
		this.context = context;
		this.resourceId = resourceId;
		this.lstPlace = lstPlace;
		this.lstOrigPlace = lstPlace;
		size = Math.min(lstOrigPlace.size(), NUM_LOAD_ELEMENTS);
		locale = Locale.getDefault();
	}
	
	@Override
	public int getCount() {
		return size;
	}

	@Override
	public Object getItem(int position) {
		if (position >= lstPlace.size()) {
			return null;
		}
		return lstPlace.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).hashCode();
	}

//	@Override
//	public int getCount() {
//		return lstPlace.size();
//	}

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
			holder.img = (ImageView) view.findViewById(R.id.imgPlaceThumbnail);
			view.setTag(holder);
		} else {
			holder = (FavoriteHolder) view.getTag();
		}

		Place place = (Place) getItem(position);
		if (place != null) {
			// check current language of the device
			String name = PlaceCursorHelper.IsDeviceEngLang() ? 
						Strings.nullToEmpty(place.getName_en()) :  // English Name
						Strings.nullToEmpty(place.getName());  // Chinese Name
			holder.tvName.setText(name);
			
			if (holder.img != null && !Strings.isNullOrEmpty(place.getUrl())) {
				imageLoader.displayImage(
						PlaceCursorHelper.getUrlByLanguage(place.getUrl()), holder.img, 
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
		}
		return view;
	}
	
	private static class FavoriteHolder {
		TextView tvName;
		ImageView img;
	}

	@Override
	public Filter getFilter() {
		if (favoriteFilter == null) {
			favoriteFilter = new FavoriteFilter();
		}
		return favoriteFilter;
	}
	
	private class FavoriteFilter extends Filter {

		protected FilterResults performFiltering(final CharSequence constraint) {

//			Locale locale = Locale.getDefault();
//			String name = "";
			FilterResults results = new FilterResults();
			if (constraint == null || constraint.length() == 0) {
//				results.count = lstOrigPlace.size();
//				results.values = lstOrigPlace;
				results.count = size;
				results.values = ImmutableList.copyOf(lstOrigPlace.subList(0, size)).asList();
			} else {
				 // filter by the name of places and show the first size number of elements
//				List<Place> filterResult = new ArrayList<Place>();
//				for (Place place : lstPlace) {
//					// check current language of the device
//					name = PlaceCursorHelper.IsDeviceEngLang() ? 
// 							  Strings.nullToEmpty(place.getName_en()).toUpperCase(locale) :  
//							  Strings.nullToEmpty(place.getName()).toUpperCase(locale);  
// 					if (name.contains(constraint.toString().toUpperCase(locale))) {
// 						 filterResult.add(place);	
// 					}
//				}
//				results.count = filterResult.size();
//				results.values = filterResult;
				
				Collection<Place> colMatchedPlace = Collections2.filter(lstPlace, 
							new MatchPlacePredicate(constraint.toString().toUpperCase(locale)));
				ImmutableList<Place> lstNoPlace = ImmutableList.of();
				ImmutableList<Place> lstMatched = colMatchedPlace == null || colMatchedPlace.size() == 0 ? lstNoPlace :
														ImmutableList.copyOf(colMatchedPlace).subList(0, size);
				results.count = lstMatched.size();
				results.values = lstMatched;
			}
			return results;
		}

		@SuppressWarnings("unchecked")
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			
			// See more at: http://www.survivingwithandroid.com/2012/10/android-listview-custom-filter-and.html#sthash.UcZKTLgE.dpuf
			// Now we have to inform the adapter about the new list filtered 
			if (results.count == 0) {
				if (results.values != null) {
					lstPlace = (List<Place>) results.values;
				} else {
					lstPlace = ImmutableList.of();
				}
				notifyDataSetInvalidated();
			} else {
				lstPlace = (List<Place>) results.values;
				notifyDataSetChanged();
			}
		}
	}
	
	private class MatchPlacePredicate implements Predicate<Place> {

		private String searchValue;
		public MatchPlacePredicate (String searchValue) {
			this.searchValue = searchValue;
		}
		public boolean apply(Place place) {
			if (place == null) {
				return false;
			}
			String name = PlaceCursorHelper.IsDeviceEngLang() ? 
						  Strings.nullToEmpty(place.getName_en()).toUpperCase(locale) :  
					  Strings.nullToEmpty(place.getName()).toUpperCase(locale); 
			return name.contains(searchValue);
		}
	};

	public void resetData() {
		this.lstPlace = lstOrigPlace;
	}

	public void filterFavorite(String strSearch) {

//		Locale locale = Locale.getDefault();
//		String name = "";
		if (strSearch != null && strSearch.length() > 0) {
			 // filter by the name of places
//			List<Place> filterResult = new ArrayList<Place> ();
//			for (Place place : lstPlace) {
//				// check current language of the device
//				name = PlaceCursorHelper.IsDeviceEngLang() ? 
//						  Strings.nullToEmpty(place.getName_en()).toUpperCase(locale) :  
//						  Strings.nullToEmpty(place.getName()).toUpperCase(locale);  
//				if (name.contains(strSearch.toString().toUpperCase(locale))) {
//					filterResult.add(place);	
//				}
//			}
//		if (filterResult.size() == 0) {
//			this.lstPlace = filterResult;
//			this.notifyDataSetInvalidated();
//		} else {
//			this.lstPlace = filterResult;
//			this.notifyDataSetChanged();
//		}
			Collection<Place> colMatchedPlace = Collections2.filter(lstPlace, 
					new MatchPlacePredicate(strSearch.toString().toUpperCase(locale)));
			ImmutableList<Place> lstNoPlace = ImmutableList.of();
			ImmutableList<Place> lstMatched = colMatchedPlace == null || colMatchedPlace.size() == 0? lstNoPlace :
														ImmutableList.copyOf(colMatchedPlace).subList(0, size);
			if (lstMatched.size() == 0) {
				this.lstPlace = lstMatched;
				this.notifyDataSetInvalidated();
			} else {
				this.lstPlace = lstMatched;
				this.notifyDataSetChanged();
			}
		}
	}

	public void updateShowCount() {
		size += NUM_LOAD_ELEMENTS;
		if (size > lstPlace.size()) {
			size = lstPlace.size();
		}
	}

}
