package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class VisitorFragment extends BaseFragment {
	
	private AdView adView;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		View rootView = (View) inflater.inflate(R.layout.fragment_visitor, container, false);
        
        // Look up the AdView as a resource and load a request.
        adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
        						.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        						.build();
        adView.loadAd(adRequest);
        return rootView;
    }
	
	@Override
	public void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}

	@Override
	public void onPause() {
		adView.pause();
		super.onPause();
	}

	@Override
	public void onResume() {
		adView.resume();
		super.onResume();
	}
}
