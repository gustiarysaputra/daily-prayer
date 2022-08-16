package com.gustiarysaputra.dailyprayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.gustiarysaputra.dailyprayer.kidung.KidungActivity
import com.gustiarysaputra.dailyprayer.prayer.PrayerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prayerCard = findViewById<CardView>(R.id.prayer)
        val kidungCard = findViewById<CardView>(R.id.kidung)
        
        prayerCard.setOnClickListener{
            prayerActivity()
        }

        kidungCard.setOnClickListener{
            kidungActivity()
        }
    }
    fun prayerActivity() {
        val intent = Intent(this, PrayerActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun kidungActivity() {
        val intent = Intent(this, KidungActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}