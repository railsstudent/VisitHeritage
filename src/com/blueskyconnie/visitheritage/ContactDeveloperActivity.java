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
}
