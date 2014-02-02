package com.blueskyconnie.visitheritage;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class HomeFragment extends BaseFragment implements OnClickListener {
	
	private AdView adView;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        // Look up the AdView as a resource and load a request.
        adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
        						.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        						.addTestDevice("3be2084011b4a10a")
        						.addTestDevice("346bc190e6be57ef")
        						.build();
        adView.loadAd(adRequest);
        
        LinearLayout ll_vert = (LinearLayout) rootView.findViewById(R.id.ll_vert);
        Button btnMonument = (Button) ll_vert.findViewById(R.id.btnMonument);
        Button btnAroundMe = (Button) ll_vert.findViewById(R.id.btnAroundMe);
        Button btnNotice = (Button) ll_vert.findViewById(R.id.btnNotice);
        Button btnContactOffice = (Button) ll_vert.findViewById(R.id.btnContactOffice);
        Button btnRating = (Button) ll_vert.findViewById(R.id.btnRating);
        
        btnMonument.setOnClickListener(this);
        btnAroundMe.setOnClickListener(this);
        btnNotice.setOnClickListener(this);
        btnContactOffice.setOnClickListener(this);
        btnRating.setOnClickListener(this);
        
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

	@Override
	public void onClick(View view) {
		
		int position = -1;
		switch (view.getId()) {
			case R.id.btnMonument:
				position = 0;
				break;
			case R.id.btnAroundMe:
				position = 1;
				break;
			case R.id.btnNotice:
				position = 2;
				break;
			case R.id.btnContactOffice:
				position = 3;
				break;
			case R.id.btnRating:
				position = 4;
				break;
			default:
				Crouton.makeText(getActivity(), getString(R.string.errUnknownBtnAction), Style.INFO).show();
				return;
		}
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			((MainActivity) this.getActivity()).selectItem(position);
		} else {
			((MainActivity) this.getActivity()).displayViewFromHome(position);
		}
	}
}
