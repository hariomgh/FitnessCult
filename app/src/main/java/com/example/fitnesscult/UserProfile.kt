package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class UserProfile : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        auth = FirebaseAuth.getInstance()


        val nameTextView = findViewById<TextView>(R.id.user_name)
        nameTextView.text = User.name

        val emailTextView = findViewById<TextView>(R.id.user_email)
        emailTextView.text = User.email

       val profileImageView = findViewById<ImageView>(R.id.user_photo)
        Glide.with(this)
            .load(User.photoUrl)
            .placeholder(R.drawable.ic_baseline_person_outline_24)
             .into(profileImageView)



        //          logout button
        findViewById<Button>(R.id.logOutBtn).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this , MainActivity::class.java))
        }



    }
}