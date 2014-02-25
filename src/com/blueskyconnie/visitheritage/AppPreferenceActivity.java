package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class AppPreferenceActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		this.getSupportFragmentManager().beginTransaction()
			.replace(android.R.id.content, new AppPreferenceFragment())
			.commit();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			supportNavigateUpTo(getSupportParentActivityIntent());
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
