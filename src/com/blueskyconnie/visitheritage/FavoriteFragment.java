package com.blueskyconnie.visitheritage;

import java.util.List;
import java.util.Set;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.blueskyconnie.visitheritage.adapter.FavoriteListAdapter;
import com.blueskyconnie.visitheritage.dao.PlaceDao;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.state.VisitHeritageState;

// http://www.survivingwithandroid.com/2013/01/android-listview-filterable.html
public class FavoriteFragment extends BaseListFragment implements View.OnClickListener {

	private VisitHeritageState state;
	private PlaceDao dao;
	private boolean isItemClicked = false;
	private EditText edtSearch;
	private FavoriteListAdapter favoriteListAdapter;
	private Button btnLoadMore;
	
	public FavoriteFragment() {
		topFragment = true;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_favorite, null);
		edtSearch = (EditText) view.findViewById(R.id.editSearch);
		edtSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable s) {	}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {	}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (before > count) {
					// We're deleting char so we need to reset the adapter data 
					favoriteListAdapter.resetData();
				}
				// apply filter
				//favoriteListAdapter.getFilter().filter(s.toString());
				favoriteListAdapter.filterFavorite(s.toString());
			}
			
		});
		btnLoadMore = (Button) view.findViewById(R.id.btnLoadMore);
		btnLoadMore.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		dao = new PlaceDao(getActivity());
		state = ((MainActivity) getActivity()).getState();
	}

	@Override
	public void onResume() {
		super.onResume();
		try {
			isItemClicked = false;
			Set<Integer> setFavIds = state.getFavorites().getFavoriteIds();
			dao.open();
			List<Place> places = dao.getFavorites(setFavIds);
			favoriteListAdapter = new FavoriteListAdapter(getActivity(), R.layout.list_item_favorite, places);
			favoriteListAdapter.filterFavorite(edtSearch.getText().toString());
			setListAdapter(favoriteListAdapter);
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (edtSearch != null) {
			hideSoftKeyboard(edtSearch);
		}
	}
	
	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		
		if (!isItemClicked) {
			// show place fragment
			Place place = (Place) listView.getItemAtPosition(position);
			if (place != null) {
				isItemClicked = true;
				hideSoftKeyboard(edtSearch);
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.PLACE_KEY, place);
				Fragment placeFragment = new PlaceFragment();
				placeFragment.setArguments(bundle);
				FragmentManager fragManager = this.getFragmentManager();
				fragManager.beginTransaction()
					.replace(R.id.frame_container, placeFragment)
					.addToBackStack(null)
					.commit();
			}
		}
	}

	private void hideSoftKeyboard(View view) {
		InputMethodManager in = (InputMethodManager) FavoriteFragment.this.getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		in = null;
	}

	@Override
	public void onClick(View v) {
		favoriteListAdapter.updateShowCount(edtSearch.getText().toString());
		favoriteListAdapter.notifyDataSetChanged();
	}
}
