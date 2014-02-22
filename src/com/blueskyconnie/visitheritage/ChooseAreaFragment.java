package com.blueskyconnie.visitheritage;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.blueskyconnie.visitheritage.adapter.ChooseAreaAdapter;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.model.Region;
import com.google.common.collect.Lists;

public class ChooseAreaFragment extends BaseListFragment {
	
	private MainActivity mainActivity;
	private boolean isItemClicked;
	
	public ChooseAreaFragment() {
		topFragment = true;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_area_new, container, false);
    }
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainActivity = (MainActivity) getActivity();
		List<Region> lstRegion = Lists.newArrayList(  
				new Region(R.string.strHK, R.drawable.img_hk, mainActivity.getState().getLstHK(), Constants.SHARE_PREF_HK)
			   , new Region(R.string.strKowloon, R.drawable.img_kln, mainActivity.getState().getLstKowloon(), 
					   Constants.SHARE_PREF_KLN)	
			   , new Region(R.string.strNT, R.drawable.img_nt, mainActivity.getState().getLstNT(), Constants.SHARE_PREF_NT)
			   , new Region(R.string.strIsland, R.drawable.img_island, mainActivity.getState().getLstIsland(), 
					   Constants.SHARE_PREF_ISLAND)
			   , new Region(R.string.strAll, R.drawable.img_all, mainActivity.getState().getLstAll(), 
					   Constants.SHARE_PREF_ALL));
		ChooseAreaAdapter adapter = new ChooseAreaAdapter(getActivity(), R.layout.list_item_area, lstRegion);
		setListAdapter(adapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		isItemClicked = false;
	}

	@Override
	public void onListItemClick(ListView listView, View v, int position, long id) {
		if (!isItemClicked) {
			Region region = (Region) listView.getItemAtPosition(position);
			if (region != null) {
				isItemClicked = true;
				invokeLocationFragment(region);
			}
		}
	}

	private void invokeLocationFragment(Region region) {

		LocationMapFragment fragment = new LocationMapFragment();
		FragmentManager fragmentManager = getFragmentManager();
		Bundle bundle = new Bundle();
		bundle.putString(Constants.PLACE_KEY, getString(region.getNameResId()));
		bundle.putParcelableArrayList(Constants.PLACES, (ArrayList<Place>) region.getSource());
		bundle.putString(Constants.REGION_KEY, region.getSharePrefKey());
		fragment.setArguments(bundle);
		fragmentManager.beginTransaction()
			.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
			.addToBackStack(null)
			.commit();
	}
	
}
