package com.blueskyconnie.visitheritage.adapter;

import java.util.List;

import com.blueskyconnie.visitheritage.R;
import com.blueskyconnie.visitheritage.model.NavDrawerItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NavDrawerListAdapter extends ArrayAdapter<NavDrawerItem> {

	private Context context;
	private int resourceId;
	private List<NavDrawerItem> lstDrawerItem;
	
	public NavDrawerListAdapter(Context context, int resource,
			List<NavDrawerItem> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resourceId = resource;
		this.lstDrawerItem = objects;
	}

	@Override
	public int getCount() {
		return lstDrawerItem.size();
	}

	@Override
	public NavDrawerItem getItem(int position) {
		return lstDrawerItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		ViewHolder holder = null;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(resourceId, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(R.id.icon);
			holder.textView = (TextView) view.findViewById(R.id.title);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		holder.imageView.setImageResource(lstDrawerItem.get(position).getIcon());
		holder.textView.setText(lstDrawerItem.get(position).getTitle());
		return view;
	}
	
	private static class ViewHolder {
		ImageView imageView;
		TextView textView;
	}

}
