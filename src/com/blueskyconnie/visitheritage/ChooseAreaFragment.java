package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.blueskyconnie.visitheritage.R;

public class ChooseAreaFragment extends BaseFragment {
	
	private Button btnPress;
	
	private OnClickListener clickListener =  new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btnPress:
					ChildFragment fragment = new ChildFragment();
					FragmentManager fragmentManager = ChooseAreaFragment.this.getFragmentManager();
					// remember parent fragment
					fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment, Constant.CHILD_TAG)
						.addToBackStack(null)
						.commit();
					break;
			}
		}
	};
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
        btnPress = (Button) rootView.findViewById(R.id.btnPress); 
        btnPress.setOnClickListener(clickListener);
        return rootView;
    }
	
	
}
