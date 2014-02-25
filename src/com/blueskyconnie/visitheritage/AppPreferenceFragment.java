package com.blueskyconnie.visitheritage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v4.preference.PreferenceFragment;
import android.util.Log;

import com.blueskyconnie.visitheritage.state.VisitHeritageState;

public class AppPreferenceFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {

	private static final String TAG = AppPreferenceFragment.class.getSimpleName();
	
	private SharedPreferences mPref;
	private VisitHeritageState state;

	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		this.addPreferencesFromResource(R.xml.preferences);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		state = ((VisitHeritageApplication) getActivity().getApplicationContext()).getState();
		mPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mPref.registerOnSharedPreferenceChangeListener(this);
		Log.i(TAG, "Register preference change listener.");
	}

	@Override
	public void onPause() {
		mPref.unregisterOnSharedPreferenceChangeListener(this);
		Log.i(TAG, "Unregister preference change listener.");
		super.onPause();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		ListPreference lstPref = (ListPreference) getPreferenceScreen().findPreference("key_around_me_distance");
		try {
			int dist = Integer.parseInt(lstPref.getValue());
			state.setAround_me_distance(dist);
			Log.i(TAG, "onSharedPreferenceChanged, dist = " + dist);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			state.setAround_me_distance(1000);
		}
	}
}
