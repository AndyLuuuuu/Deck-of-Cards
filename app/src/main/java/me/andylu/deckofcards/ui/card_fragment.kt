package me.andylu.deckofcards.ui


import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import me.andylu.deckofcards.R
import me.andylu.deckofcards.controller.flingGesture

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class card_fragment : Fragment() {

    fun newInstance(value: String, suit: Int): card_fragment {
        val fragment = card_fragment()
        val args = Bundle()
        args.putString("value", value)
        args.putInt("suit", suit)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_card_fragment, container, false)
        val valueTextTop = view.findViewById<TextView>(R.id.value_text_top)
        val valueTextBottom = view.findViewById<TextView>(R.id.value_text_bottom)
        val suitTop = view.findViewById<ImageView>(R.id.suit_top_image)
        val suitBottom = view.findViewById<ImageView>(R.id.suit_bottom_image)

        val value = arguments?.getString("value")
        val suit = ContextCompat.getDrawable(context!!, arguments?.getInt("suit")!!)
        valueTextTop.text = value
        valueTextBottom.text = value

        suitTop.setImageDrawable(suit)
        suitBottom.setImageDrawable(suit)

        val flingGesture = flingGesture.setup(context, fragmentManager, tag, 200f)
        view.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                AnimatorInflater.loadAnimator(context, R.animator.flip_in).apply {
                    setTarget(view)
                    start()
                }
            }
            flingGesture.onTouchEvent(event)
        }

        return view
    }


}
