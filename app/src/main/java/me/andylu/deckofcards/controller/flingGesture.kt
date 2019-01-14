package me.andylu.deckofcards.controller

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import me.andylu.deckofcards.R

class flingGesture(
    private val fragmentManager: FragmentManager?,
    private val fragmentTag: String?,
    private val SWIPE_MIN_DISTANCE: Float
) : GestureDetector.OnGestureListener {
    companion object {
        fun setup(
            context: Context?,
            fragmentManager: FragmentManager?,
            fragmentTag: String?,
            SWIPE_MIN_DISTANCE: Float
        ): GestureDetectorCompat {
            return GestureDetectorCompat(context, flingGesture(fragmentManager, fragmentTag, SWIPE_MIN_DISTANCE))
        }
    }

    override fun onShowPress(e: MotionEvent?) {
        return
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if ((e1!!.rawX - e2!!.rawX) > SWIPE_MIN_DISTANCE) {
            // SET ANIMATIONS HERE
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.setCustomAnimations(0, R.anim.exit_to_left)
            val targetFragment = fragmentManager?.findFragmentByTag(fragmentTag)
            if (fragmentManager != null && targetFragment != null) {
                fragmentTransaction?.remove(targetFragment)?.commit()
            }
        }
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        return
    }
}