package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ContactDeveloperActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_developer);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		if (item.getItemId() == android.R.id.home) {
////			NavUtils.navigateUpFromSameTask(this);
//			supportNavigateUpTo(getSupportParentActivityIntent());
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
