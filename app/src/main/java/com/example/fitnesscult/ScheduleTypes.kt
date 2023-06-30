package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ScheduleTypes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_types)

        val gymWorkoutBtn = findViewById<CardView>(R.id.gymWorkOutBtn)

        gymWorkoutBtn.setOnClickListener {
            intent = Intent(applicationContext, ScheduleList::class.java)
            startActivity(intent)
        }

        val yogaWorkoutBtn = findViewById<CardView>(R.id.yogaWorkOutBtn)

        yogaWorkoutBtn.setOnClickListener {
            intent = Intent(applicationContext, YogaScheduleList::class.java)
            startActivity(intent)
        }

        val cardioWorkoutBtn = findViewById<CardView>(R.id.cardioWorkOutBtn)

        cardioWorkoutBtn.setOnClickListener {
            intent = Intent(applicationContext, CardioScheduleList::class.java)
            startActivity(intent)
        }


        //intents for floating buttons

        val chatGptBtn = findViewById<FloatingActionButton>(R.id.chatGptFloating)

        chatGptBtn.setOnClickListener {
            //open a new activity
            intent = Intent(applicationContext, ChatGpt::class.java)
            startActivity(intent)
        }

        val trainerBtn = findViewById<FloatingActionButton>(R.id.trainerFloating)

        trainerBtn.setOnClickListener {
            //open a new activity
            intent = Intent(applicationContext, ContactUs::class.java)
            startActivity(intent)
        }

        val spotifyBtn = findViewById<FloatingActionButton>(R.id.spotifyFloating)

        spotifyBtn.setOnClickListener {
            //open a new activity
            intent = Intent(applicationContext, Spotify::class.java)
            startActivity(intent)
        }
    }
}