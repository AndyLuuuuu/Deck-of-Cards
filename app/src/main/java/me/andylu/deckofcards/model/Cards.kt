package me.andylu.deckofcards.model

import me.andylu.deckofcards.R

class Cards {
    val suits = arrayOf(R.drawable.ic_club_icon, R.drawable.ic_spade_icon, R.drawable.ic_diamond_icon, R.drawable.ic_heart_icon)
    val values = arrayOf(1,2,3,4,5,6,7,8,9,10)
    val faces = arrayOf("J","Q","K")

    fun prepareCards():MutableList<Array<String>> {
        val cards:MutableList<Array<String>> = mutableListOf()
            for (suit in suits) {
                for (value in values) {
                    cards.add(arrayOf(value.toString(), suit.toString() ))
                }
                for (face in faces ) {
                    cards.add(arrayOf(face, suit.toString()))
                }
            }
        return cards
    }
}