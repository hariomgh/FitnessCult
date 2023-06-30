package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        replaceWithFragment(HomeFragment())
        //by default home screen will be visible to the user

        bottomView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item0 -> replaceWithFragment(HomeFragment())
                R.id.item1 -> replaceWithFragment(FitnessFragment())
                R.id.item2 -> replaceWithFragment(Diet())
                R.id.item3 -> replaceWithFragment(Schedule())
                else -> {

                }
            }
            true
        }
    }

    override fun onBackPressed() {
        // Navigate to MainActivity instead of Profile activity when back button is pressed
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}