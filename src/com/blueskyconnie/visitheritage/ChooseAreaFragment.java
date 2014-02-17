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

//public class ChooseAreaFragment extends BaseFragment {
public class ChooseAreaFragment extends BaseListFragment {
	
//	private Button btnHK;
//	private Button btnKowloon;
//	private Button btnNT;
//	private Button btnIsland;
//	private Button btnAll;
	private MainActivity mainActivity;
	private boolean isItemClicked;
//	private View header_view;
	
//	private OnClickListener clickListener =  new OnClickListener() {
//
//		public void onClick(View v) {
//			FragmentManager fragmentManager = ChooseAreaFragment.this.getFragmentManager();
//			setButtonEnabled(false, false, false, false);
//			LocationMapFragment fragment = new LocationMapFragment();
//			Bundle bundle = new Bundle();
//			switch (v.getId()) {
//				case R.id.btnHK:
//					bundle.putString(Constants.PLACE_KEY, getString(R.string.strHK));
//					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstHK());
//					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_HK);
//					fragment.setArguments(bundle);
//					fragmentManager.beginTransaction()
//						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
//						.addToBackStack(null)
//						.commit();
//					break;
//				case R.id.btnKowloon:
//					bundle.putString(Constants.PLACE_KEY, getString(R.string.strKowloon));
//					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstKowloon());
//					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_KLN);
//					fragment.setArguments(bundle);
//					fragmentManager.beginTransaction()
//						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
//						.addToBackStack(null)
//						.commit();
//					break;
//				case R.id.btnNT:
//					bundle.putString(Constants.PLACE_KEY, getString(R.string.strNT));
//					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstNT());
//					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_NT);
//					fragment.setArguments(bundle);
//					fragmentManager.beginTransaction()
//						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
//						.addToBackStack(null)
//						.commit();
//					break;
//				case R.id.btnIsland:
//					bundle.putString(Constants.PLACE_KEY, getString(R.string.strIsland));
//					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstIsland());
//					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_ISLAND);
//					fragment.setArguments(bundle);
//					fragmentManager.beginTransaction()
//						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
//						.addToBackStack(null)
//						.commit();
//					break;
//				case R.id.btnAll:
//					bundle.putString(Constants.PLACE_KEY, getString(R.string.strAll));
//					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getState().getLstAll());
//					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_ALL);
//					fragment.setArguments(bundle);
//					fragmentManager.beginTransaction()
//						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
//						.addToBackStack(null)
//						.commit();
//					break;
//			}
//		}
//	};
	
	
	public ChooseAreaFragment() {
		topFragment = true;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
//        View rootView = inflater.inflate(R.layout.fragment_area, container, false);
//        btnHK = (Button) rootView.findViewById(R.id.btnHK); 
//        btnKowloon = (Button) rootView.findViewById(R.id.btnKowloon); 
//        btnNT = (Button) rootView.findViewById(R.id.btnNT); 
//        btnIsland = (Button) rootView.findViewById(R.id.btnIsland); 
//        btnAll = (Button) rootView.findViewById(R.id.btnAll);
//        
//        btnHK.setOnClickListener(clickListener);
//        btnKowloon.setOnClickListener(clickListener);
//        btnNT.setOnClickListener(clickListener);
//        btnIsland.setOnClickListener(clickListener);
//        btnAll.setOnClickListener(clickListener);

      View rootView = inflater.inflate(R.layout.fragment_area_new, container, false);
 //     header_view = inflater.inflate(R.layout.area_header, null);
      
      
//      btnHK = (Button) rootView.findViewById(R.id.btnHK); 
//      btnKowloon = (Button) rootView.findViewById(R.id.btnKowloon); 
//      btnNT = (Button) rootView.findViewById(R.id.btnNT); 
//      btnIsland = (Button) rootView.findViewById(R.id.btnIsland); 
//      btnAll = (Button) rootView.findViewById(R.id.btnAll);
//      
//      btnHK.setOnClickListener(clickListener);
//      btnKowloon.setOnClickListener(clickListener);
//      btnNT.setOnClickListener(clickListener);
//      btnIsland.setOnClickListener(clickListener);
//      btnAll.setOnClickListener(clickListener);

        return rootView;
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainActivity = (MainActivity) getActivity();

//		getListView().addHeaderView(header_view);
//	    getListView().setHeaderDividersEnabled(true);

		List<Region> lstRegion = new ArrayList<Region>();
		lstRegion.add(new Region(R.string.strHK, mainActivity.getState().getLstHK().size(), ""));
		lstRegion.add(new Region(R.string.strKowloon, mainActivity.getState().getLstKowloon().size(), ""));
		lstRegion.add(new Region(R.string.strNT, mainActivity.getState().getLstNT().size(), ""));
		lstRegion.add(new Region(R.string.strIsland, mainActivity.getState().getLstIsland().size(), ""));
		lstRegion.add(new Region(R.string.strAll, mainActivity.getState().getLstAll().size(), ""));
		ChooseAreaAdapter adapter = new ChooseAreaAdapter(getActivity(), R.layout.list_item_area, lstRegion);
		setListAdapter(adapter);
		
	}
	
//	private void setButtonEnabled(boolean hkEnabled, boolean klnEnabled, 
//			boolean ntEnabled, boolean islandEnabled) {
//		btnHK.setEnabled(hkEnabled);
//		btnKowloon.setEnabled(klnEnabled);
//		btnNT.setEnabled(ntEnabled);
//		btnIsland.setEnabled(islandEnabled);
//	}
	
	@Override
	public void onResume() {
		super.onResume();
		// enable the buttons when this fragment is revisited
		//setButtonEnabled(true, true, true, true);
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
