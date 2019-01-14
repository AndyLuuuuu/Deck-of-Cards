package me.andylu.deckofcards.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.andylu.deckofcards.R
import me.andylu.deckofcards.model.Cards

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cards = Cards().prepareCards().shuffled()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        cards.forEach {
            Log.d("cardcardcard", "${it[0]} ${resources.getString(it[1].toInt())}")
            transaction.add(R.id.container, card_fragment().newInstance(it[0], it[1].toInt()), "${it[0]} ${it[1]}")
        }
        transaction.commit()
    }
}
