package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
//public class ContactDeveloperActivity extends Activity {
public class ContactDeveloperActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_developer);
		
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//			getActionBar().setDisplayHomeAsUpEnabled(true);
//		}
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}
