package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements FragmentLevel {
	
	private boolean isTopFragment;
	
	public BaseFragment(boolean isTopFragment) {
		this.isTopFragment = isTopFragment;
	}
	
	public BaseFragment() {
		this(true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	public void setTopFragment(boolean isTopFragment) {
		this.isTopFragment = isTopFragment;
	}

	@Override
	public boolean isTopFragment() {
		return isTopFragment;
	}	
}
