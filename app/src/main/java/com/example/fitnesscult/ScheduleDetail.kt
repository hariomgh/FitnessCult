package com.example.fitnesscult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ScheduleDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_detail)

        val imageId = intent.getIntExtra("imageId", R.drawable.squats)
        val headingIV = findViewById<ImageView>(R.id.scheduleImage)

        headingIV.setImageResource(imageId)

    }
}