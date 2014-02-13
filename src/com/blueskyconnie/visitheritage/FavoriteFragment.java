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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class FavoriteFragment extends BaseListFragment {

	private VisitHeritageState state;
	private PlaceDao dao;
	
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
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}
}
