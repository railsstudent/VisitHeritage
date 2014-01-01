package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueskyconnie.visitheritage.R;

public class GrandchildFragment extends BaseFragment {
	
	public GrandchildFragment() {
		// not a top level fragment
		super(false);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grandchild, container, false);
        return rootView;
    }
}
