package com.blueskyconnie.visitheritage.adapter;

import java.util.List;

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
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Region;
import com.google.common.base.Strings;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class ChooseAreaAdapter extends ArrayAdapter<Region>  {

	private static final String TAG = ChooseAreaAdapter.class.getSimpleName();
	
	private Context context;
	private int resourceId;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	private List<Region> lstRegion;
	
	public ChooseAreaAdapter(Context context, int resourceId, List<Region> lstRegion) {
		
		super(context, resourceId, lstRegion);
		this.context = context;
		this.resourceId = resourceId;
		this.lstRegion = lstRegion;
	}

	@Override
	public int getCount() {
		return lstRegion.size();
	}

	@Override
	public Region getItem(int position) {
		return lstRegion.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).hashCode();
	}

	@SuppressLint("DefaultLocale")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		RegionHolder holder = null;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resourceId, null);
			holder = new RegionHolder();
			holder.tvName = (TextView) view.findViewById(R.id.tvName);
			holder.tvNumMonument = (TextView) view.findViewById(R.id.tvNumMonument);
			holder.img = (ImageView) view.findViewById(R.id.imgPlaceThumbnail);
			view.setTag(holder);
		} else {
			holder = (RegionHolder) view.getTag();
		}

		Region region = getItem(position);
		holder.tvName.setText(context.getString(region.getNameResId()));
		holder.tvNumMonument.setText(context.getResources().getQuantityString(R.plurals.monuments, region.getNumMonument(), region.getNumMonument())); 
		if (holder.img != null && !Strings.isNullOrEmpty(region.getImgUrl())) {
			imageLoader.displayImage(PlaceCursorHelper.getUrlByLanguage(region.getImgUrl()), holder.img, 
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
	
	private static class RegionHolder {
		TextView tvName;
		TextView tvNumMonument;
		ImageView img;
	}
		
}
