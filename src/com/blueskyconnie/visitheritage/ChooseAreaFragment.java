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
import com.blueskyconnie.visitheritage.model.Region;

public class ChooseAreaFragment extends BaseListFragment {
	
	private MainActivity mainActivity;
	private boolean isItemClicked;
	
	public ChooseAreaFragment() {
		topFragment = true;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

      return inflater.inflate(R.layout.fragment_area_new, container, false);
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainActivity = (MainActivity) getActivity();

		List<Region> lstRegion = new ArrayList<Region>();
		lstRegion.add(new Region(R.string.strHK, mainActivity.getState().getLstHK().size(), 
				R.drawable.img_hk));
		lstRegion.add(new Region(R.string.strKowloon, mainActivity.getState().getLstKowloon().size(), 
				R.drawable.img_kln));
		lstRegion.add(new Region(R.string.strNT, mainActivity.getState().getLstNT().size(), 
				R.drawable.img_nt));
		lstRegion.add(new Region(R.string.strIsland, mainActivity.getState().getLstIsland().size(), 
				R.drawable.img_island));
		lstRegion.add(new Region(R.string.strAll, mainActivity.getState().getLstAll().size(), R.drawable.img_hk));
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
			LocationMapFragment fragment = new LocationMapFragment();
			FragmentManager fragmentManager = getFragmentManager();
			Bundle bundle = new Bundle();
			// show locationMap fragment
			switch (position) {
				case 0:
					if (region != null) {
						isItemClicked = true;
						bundle.putString(Constants.PLACE_KEY, getString(R.string.strHK));
						bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstHK());
						bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_HK);
						fragment.setArguments(bundle);
						fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
							.addToBackStack(null)
							.commit();
					} 
					break;
				case 1:
					isItemClicked = true;
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strKowloon));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstKowloon());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_KLN);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case 2:
					isItemClicked = true;
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strNT));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstNT());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_NT);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case 3:
					isItemClicked = true;
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strIsland));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstIsland());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_ISLAND);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case 4:
					isItemClicked = true;
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strAll));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstAll());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_ALL);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				default:
					break;
			}
		}
	}
	
}
