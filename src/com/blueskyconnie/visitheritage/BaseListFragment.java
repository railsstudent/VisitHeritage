package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class BaseListFragment extends ListFragment implements FragmentLevel {

	private boolean isTopFragment;
	
	public BaseListFragment() {
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public boolean isTopFragment() {
		return isTopFragment;
	}

	@Override
	public void setTopFragment(boolean topFragment) {
		this.isTopFragment = topFragment;
	}
}
