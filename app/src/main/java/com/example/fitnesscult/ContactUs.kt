package com.example.fitnesscult

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class ContactUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        val trainer1Call = findViewById<CardView>(R.id.trainer1Card)

        trainer1Call.setOnClickListener{
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "123456789")
            startActivity(dialIntent)
        }

        val trainer2Call = findViewById<CardView>(R.id.trainer2Card)

        trainer2Call.setOnClickListener{
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "9687868564")
            startActivity(dialIntent)
        }

        val trainer3Call = findViewById<CardView>(R.id.trainer3Card)

        trainer3Call.setOnClickListener{
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "8765675768")
            startActivity(dialIntent)
        }
    }
}