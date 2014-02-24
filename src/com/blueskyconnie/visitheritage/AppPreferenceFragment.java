package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.preference.PreferenceFragment;

public class AppPreferenceFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		this.addPreferencesFromResource(R.xml.preferences);
	}
}
