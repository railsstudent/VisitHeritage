package com.blueskyconnie.visitheritage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class WikiActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wiki);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			Intent upIntent = getSupportParentActivityIntent();
			upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		
			supportNavigateUpTo(upIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
