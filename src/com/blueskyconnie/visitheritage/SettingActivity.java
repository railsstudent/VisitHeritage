package com.blueskyconnie.visitheritage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
//public class SettingActivity extends ListActivity {
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
		this.setListAdapter(adapter);
		
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//			getActionBar().setDisplayHomeAsUpEnabled(true);
//		}
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onListItemClick(ListView lv, View view, int position, long id) {
		
		Intent intent = null;
		switch (position) {
			case 0:
				intent = new Intent(this, WikiActivity.class);
				startActivity(intent);
				break;
			case 1:
				intent = new Intent(this, ContactDeveloperActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(this, AboutActivity.class);
				startActivity(intent);
				break;
		}
	}
}
