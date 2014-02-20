package com.blueskyconnie.visitheritage.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.model.Region;

public class ChooseAreaAdapter extends ArrayAdapter<Region>  {

	private Context context;
	private int resourceId;
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
		holder.img.setImageResource(region.getImageResId());
		return view;
	}
	
	private static class RegionHolder {
		TextView tvName;
		TextView tvNumMonument;
		ImageView img;
	}
		
}
