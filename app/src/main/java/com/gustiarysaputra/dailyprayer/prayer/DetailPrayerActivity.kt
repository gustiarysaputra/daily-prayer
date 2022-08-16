package com.gustiarysaputra.dailyprayer.prayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.gustiarysaputra.dailyprayer.R
import kotlinx.coroutines.NonCancellable.start

class DetailPrayerActivity : AppCompatActivity() {
    private var mediaPlayer:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_prayer)

        val detailTitle: TextView = findViewById(R.id.detail_title)
        val detailDesc: TextView = findViewById(R.id.detail_desc)
        val detailImage: ImageView = findViewById(R.id.detail_image)
        val buttonPlay: Button = findViewById(R.id.mediaButton)

        val bundle: Bundle?= intent.extras
        val title = bundle!!.getString("title")
        val desc = bundle!!.getString("desc")
        val image = bundle!!.getInt("image")
        val raw = bundle!!.getInt("raw")
        var buttonStatus = 0

        detailTitle.text = title
        detailDesc.text = desc
        detailImage.setImageResource(image)
        mediaPlayer = MediaPlayer.create(this, raw)
        mediaPlayer?.setOnPreparedListener {
            println("Ready")
        }

        buttonPlay.setOnClickListener {
            buttonStatus = if (buttonStatus==0) {
                buttonPlay.text = "Stop"
                mediaPlayer?.start()
                1
            } else {
                buttonPlay.text = "Play"
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
                0
            }
        }
    }
}