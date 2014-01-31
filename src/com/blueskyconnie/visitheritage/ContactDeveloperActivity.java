package com.blueskyconnie.visitheritage;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

public class ContactDeveloperActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_developer);
		
		ActionBar actionBar = this.getActionBar();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}
}
