package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class AboutActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_new);
		
		TextView tvCopyright = (TextView) findViewById(R.id.tvAppCopyright);
		tvCopyright.setText(String.format("%s %s %s", getString(R.string.app_name), getString(R.string.copyright), 
				getString(R.string.copyright_year)));
		
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
