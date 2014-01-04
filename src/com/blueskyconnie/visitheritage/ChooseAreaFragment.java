package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class ChooseAreaFragment extends BaseFragment {
	
	private Button btnHK;
	private Button btnKowloon;
	private Button btnNT;
	private Button btnIsland;
	
	private OnClickListener clickListener =  new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btnHK:
					setButtonEnabled(false, false, false, false);
					ChildFragment fragment = new ChildFragment();
					FragmentManager fragmentManager = ChooseAreaFragment.this.getFragmentManager();
					// remember parent fragment
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constants.MAP_TAG)
						.addToBackStack(null)
						.commit();
					break;
				case R.id.btnKowloon:
					Crouton.makeText(ChooseAreaFragment.this.getActivity(), "Todo: Show map (kowloon)", Style.INFO).show();
					// disable all buttons, so user either waits for Map to load and display or select drawer to go to other fragment
					setButtonEnabled(false, false, false, false);
					break;
				case R.id.btnNT:
					Crouton.makeText(ChooseAreaFragment.this.getActivity(), "Todo: Show map (NT)", Style.INFO).show();
					setButtonEnabled(false, false, false, false);
					break;
				case R.id.btnIsland:
					Crouton.makeText(ChooseAreaFragment.this.getActivity(), "Todo: Show map (Island)", Style.INFO).show();
					setButtonEnabled(false, false, false, false);
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
		Crouton.makeText(getActivity(), "ChooseAreaFragment: onResume)", Style.INFO).show();
		// enable the buttons when this fragment is revisited
		setButtonEnabled(true, true, true, true);
	}

	
	
}
