package com.blueskyconnie.visitheritage;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.text.util.Linkify;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ContactUsFragment extends BaseFragment {
	
	private Button btnMonument;
	private Button btnHeritage;
	private ViewFlipper viewFlipper;
	
	private Animation slide_in_left;
	private Animation slide_out_left;
	private Animation slide_in_right;
	private Animation slide_out_right;
	
	private GestureDetectorCompat gestureDetector;
	
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
				case R.id.btnHeritage:
					swipeLeft();
					break;
				case R.id.btnMonument:
					swipeRight();
					break;
				default:
					break;
			}
		}
		
	};
	
	private GestureDetector.SimpleOnGestureListener myGestureListener = new GestureDetector.SimpleOnGestureListener() {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {

			final float sensitivity = 50;
			if ((e1.getX() - e2.getX()) > sensitivity) {
				swipeLeft();
			} else if (e2.getX() - e1.getX() > sensitivity) {
				swipeRight();
			}
			return true;
		}
	};
	
	private void swipeRight() {
		// show layout of monument office
		viewFlipper.setInAnimation(slide_in_left);
		viewFlipper.setOutAnimation(slide_out_right);
		viewFlipper.showNext();
		controlButtons();
	}
	
	private void swipeLeft() {
		// show layout of heritage office
		viewFlipper.setInAnimation(slide_out_left);
		viewFlipper.setOutAnimation(slide_in_right);
		
		viewFlipper.showPrevious();
		controlButtons();
	}
	
	private void controlButtons() {
		// determine the layout that is currently visible in viewflipper
		int childIndex = viewFlipper.getDisplayedChild();
		btnMonument.setEnabled(childIndex == 0);
		btnHeritage.setEnabled(childIndex == 1);
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
        
        gestureDetector = new GestureDetectorCompat(getActivity(), myGestureListener);
        
		viewFlipper = (ViewFlipper) rootView.findViewById(R.id.flipper);
		rootView.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		});

        // add button on click listener
        btnHeritage = (Button) rootView.findViewById(R.id.btnHeritage);
        btnMonument = (Button) rootView.findViewById(R.id.btnMonument);

        btnHeritage.setOnClickListener(listener);
        btnMonument.setOnClickListener(listener);
        controlButtons();
        
        return rootView;
    }
	
	public GestureDetectorCompat getGestureDetector() {
		return gestureDetector;
	}
}


