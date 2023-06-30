package com.example.fitnesscult


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        auth = FirebaseAuth.getInstance()




    // set the user information in the Profile activity
    val displayName = intent.getStringExtra("name")
    val email = intent.getStringExtra("email")
    val photoUrl = intent.getStringExtra("photoUrl")

    User.name = displayName
    User.email = email
    User.photoUrl = photoUrl




    findViewById<TextView>(R.id.textView).text = email

    findViewById<TextView>(R.id.email).text = displayName


        Glide.with(this)
            .load(photoUrl)
            .placeholder(R.drawable.ic_baseline_person_outline_24)
            .into(findViewById<ImageView>(R.id.profileImageView))



            // for going to home page

        val fitnessTodayBtn = findViewById<Button>(R.id.fitnessForTodayBtn)

        fitnessTodayBtn.setOnClickListener {
            //open a new activity
            intent = Intent(applicationContext, BottomNavigation::class.java)
            startActivity(intent)
        }

    //          logout button
            findViewById<Button>(R.id.signOutBtn).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this , MainActivity::class.java))
        }


    // intent to move it to home screen
    val intent = Intent(this, BottomNavigation::class.java)
    startActivity(intent)



}
}