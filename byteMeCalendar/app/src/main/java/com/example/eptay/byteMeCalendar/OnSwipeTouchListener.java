package com.example.eptay.byteMeCalendar;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


/*
    Class to create an object that can detect the direction of a swipe event.
*/


public class OnSwipeTouchListener implements OnTouchListener {

    /* MEMBER VARIABLES */
    private final GestureDetector gestureDetector;

    /* METHODS */
    /**
     * This method takes in a context and determines gesture
     * @param context
     * @return n/a
     */
    public OnSwipeTouchListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }

    /**
     * This method detects event touch
     * @param v
     * @param event
     * @return detector on event
     */
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    /* FINAL CLASS */
    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        /**
         * Method for down gesture
         * @param e
         * @return true
         */
        public boolean onDown(MotionEvent e) {
            return true;
        }

        /**
         * Method for fling gesture
         * @param e1
         * @param e2
         * @param velocityX
         * @param velocityY
         * @return boolean
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX > 0)
                    onSwipeRight();
                else
                    onSwipeLeft();
                return true;
            }
            return false;
        }
    }

}