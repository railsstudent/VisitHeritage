package com.blueskyconnie.visitheritage;

import java.util.List;
import java.util.Set;

import com.blueskyconnie.visitheritage.adapter.AroundMeListAdapter;
import com.blueskyconnie.visitheritage.adapter.FavoriteListAdapter;
import com.blueskyconnie.visitheritage.dao.PlaceDao;
import com.blueskyconnie.visitheritage.helper.FavoritePlaceHolder;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class FavoriteFragment extends BaseListFragment {

	private VisitHeritageState state;
	private PlaceDao dao;
	private boolean isItemClicked = false;
	
	public FavoriteFragment() {
		topFragment = true;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_favorite, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		dao = new PlaceDao(getActivity());
		try {
			state = ((MainActivity) getActivity()).getState();
			FavoritePlaceHolder holder = state.getFavorites();
			Set<Integer> setFavIds = holder.getFavoriteIds();
			dao.open();
			List<Place> places = dao.getFavorites(setFavIds);
			AroundMeListAdapter favoriteListAdapter = new AroundMeListAdapter(getActivity(),
					R.layout.list_item_aroundme, places);
			setListAdapter(favoriteListAdapter);
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		try {
			isItemClicked = false;
			FavoritePlaceHolder holder = state.getFavorites();
			Set<Integer> setFavIds = holder.getFavoriteIds();
			dao.open();
			List<Place> places = dao.getFavorites(setFavIds);
			FavoriteListAdapter favoriteListAdapter = new FavoriteListAdapter(getActivity(),
					R.layout.list_item_favorite, places);
			setListAdapter(favoriteListAdapter);
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
	}

	
	@Override
	public void onListItemClick(ListView listView, View v, int position, long id) {
		
		if (!isItemClicked) {
			isItemClicked = true;
			// show place fragment
			Place place = (Place) listView.getItemAtPosition(position);
			if (place != null) {
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.PLACE_KEY, place);
				Fragment placeFragment = new PlaceFragment();
				placeFragment.setArguments(bundle);
				FragmentManager fragManager = this.getFragmentManager();
				fragManager.beginTransaction()
					.replace(R.id.frame_container, placeFragment)
					.addToBackStack(null)
					.commit();
			}  else {
				isItemClicked = false;
			}
		}
	}
}
