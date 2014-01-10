package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class BaseListFragment extends ListFragment implements FragmentLevel {

	protected boolean topFragment;
	
	public BaseListFragment() {
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public boolean isTopFragment() {
		return topFragment;
	}

	@Override
	public void setTopFragment(boolean topFragment) {
		this.topFragment = topFragment;
	}
}
