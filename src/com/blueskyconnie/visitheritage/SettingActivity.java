package com.blueskyconnie.visitheritage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SettingActivity extends ActionBarListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				this.getResources().getStringArray(R.array.setting_array)) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
		          View view =super.getView(position, convertView, parent);
		            TextView textView=(TextView) view.findViewById(android.R.id.text1);
		            textView.setTextColor(Color.BLACK);
		            return view;
			}
		};
		setListAdapter(adapter);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Intent intent = null;
				switch (position) {
					case 0:
						intent = new Intent(SettingActivity.this, WikiActivity.class);
						startActivity(intent);
						break;
					case 1:
						intent = new Intent(SettingActivity.this, ContactDeveloperActivity.class);
						startActivity(intent);
						break;
					case 2:
						intent = new Intent(SettingActivity.this, AboutActivity.class);
						startActivity(intent);
						break;
				}
			}
			
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
		    // Respond to the action bar's Up/Home button
		    case android.R.id.home:
		    	supportNavigateUpTo(getSupportParentActivityIntent());
		    	return true;
		    }
		    return super.onOptionsItemSelected(item);
	}
}
