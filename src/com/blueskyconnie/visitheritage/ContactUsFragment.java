package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ContactUsFragment extends BaseFragment implements OnItemSelectedListener {
	
	private ViewFlipper viewFlipper;
	
	private Animation slide_in_left;
	private Animation slide_out_left;
	private Animation slide_in_right;
	private Animation slide_out_right;
	
//	private GestureDetectorCompat gestureDetector;
	
//	private GestureDetector.SimpleOnGestureListener myGestureListener = new GestureDetector.SimpleOnGestureListener() {
//
//		@Override
//		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
//				float velocityY) {
//
//			final float sensitivity = 50;
//			if ((e1.getX() - e2.getX()) > sensitivity) {
//				swipeLeft();
//			} else if (e2.getX() - e1.getX() > sensitivity) {
//				swipeRight();
//			}
//			return true;
//		}
//	};
	
	private void swipeRight() {
		// show layout of monument office
		viewFlipper.setInAnimation(slide_in_left);
		viewFlipper.setOutAnimation(slide_out_right);
		viewFlipper.showNext();
	}
	
	private void swipeLeft() {
		// show layout of heritage office
		viewFlipper.setInAnimation(slide_out_left);
		viewFlipper.setOutAnimation(slide_in_right);
		viewFlipper.showPrevious();
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
         
        // set autolink of phone, I think it is a bug of Android
        TextView tvPhoneMonu = (TextView) rootView.findViewById(R.id.tvMonuPhone);
        Linkify.addLinks(tvPhoneMonu, Linkify.PHONE_NUMBERS);
        
        slide_in_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left);
        slide_out_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
        slide_in_right = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        slide_out_right = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_right);
        
//        gestureDetector = new GestureDetectorCompat(getActivity(), myGestureListener);
        
		viewFlipper = (ViewFlipper) rootView.findViewById(R.id.flipper);
//		rootView.setOnTouchListener(new OnTouchListener() {
//			public boolean onTouch(View v, MotionEvent event) {
//				return gestureDetector.onTouchEvent(event);
//			}
//		});

		Spinner spDepts = (Spinner) rootView.findViewById(R.id.spDept);
		spDepts.setOnItemSelectedListener(this);
		
        return rootView;
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
		int displayedChild = viewFlipper.getDisplayedChild();
		if (position == displayedChild) {
			return;
		} else if (position > displayedChild) {
			swipeLeft();
		} else {
			swipeRight();
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}
	
//	public GestureDetectorCompat getGestureDetector() {
//		return gestureDetector;
//	}
}


