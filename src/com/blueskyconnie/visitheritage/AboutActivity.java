package com.blueskyconnie.visitheritage;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_new);
		
		TextView tvChiDS = (TextView) findViewById(R.id.tvChiDS);
		TextView tvEngDS = (TextView) findViewById(R.id.tvEngDS);

		String fmt = "%s %s";
		tvChiDS.setText(String.format(fmt, getString(R.string.strChi), getString(R.string.strChiDS)));
		tvEngDS.setText(String.format(fmt, getString(R.string.strEng), getString(R.string.strEngDS)));
		
		TextView tvCopyright = (TextView) findViewById(R.id.tvAppCopyright);
		tvCopyright.setText(String.format("%s %s %s", getString(R.string.app_name), getString(R.string.copyright), 
				getString(R.string.copyright_year)));
		
		ActionBar actionBar = this.getActionBar();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}
}
