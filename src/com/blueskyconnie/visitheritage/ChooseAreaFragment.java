package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ChooseAreaFragment extends BaseFragment {
	
	private Button btnHK;
	private Button btnKowloon;
	private Button btnNT;
	private Button btnIsland;
	private MainActivity mainActivity;
	
	private OnClickListener clickListener =  new OnClickListener() {

		public void onClick(View v) {
			FragmentManager fragmentManager = ChooseAreaFragment.this.getFragmentManager();
			setButtonEnabled(false, false, false, false);
			LocationMapFragment fragment = new LocationMapFragment();
			Bundle bundle = new Bundle();
			switch (v.getId()) {
				case R.id.btnHK:
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strHK));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getLstHK());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_HK);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case R.id.btnKowloon:
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strKowloon));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getLstKowloon());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_KLN);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case R.id.btnNT:
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strNT));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getLstNT());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_NT);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case R.id.btnIsland:
					bundle.putString(Constants.PLACE_KEY, getString(R.string.strIsland));
					bundle.putParcelableArrayList(Constants.PLACES, mainActivity.getLstIsland());
					bundle.putString(Constants.REGION_KEY, Constants.SHARE_PREF_ISLAND);
					fragment.setArguments(bundle);
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
			}
		}
	};
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_area, container, false);
        btnHK = (Button) rootView.findViewById(R.id.btnHK); 
        btnKowloon = (Button) rootView.findViewById(R.id.btnKowloon); 
        btnNT = (Button) rootView.findViewById(R.id.btnNT); 
        btnIsland = (Button) rootView.findViewById(R.id.btnIsland); 
        
        btnHK.setOnClickListener(clickListener);
        btnKowloon.setOnClickListener(clickListener);
        btnNT.setOnClickListener(clickListener);
        btnIsland.setOnClickListener(clickListener);
        return rootView;
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainActivity = (MainActivity) getActivity();
	}
	
	private void setButtonEnabled(boolean hkEnabled, boolean klnEnabled, 
			boolean ntEnabled, boolean islandEnabled) {
		btnHK.setEnabled(hkEnabled);
		btnKowloon.setEnabled(klnEnabled);
		btnNT.setEnabled(ntEnabled);
		btnIsland.setEnabled(islandEnabled);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		// enable the buttons when this fragment is revisited
		setButtonEnabled(true, true, true, true);
	}

	
	
}
