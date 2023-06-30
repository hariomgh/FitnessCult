package com.example.fitnesscult

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_home, container, false)

        // for profile button
        val profileBtn = view?.findViewById<CircleImageView>(R.id.profile_image)

        profileBtn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, UserProfile::class.java)
                     // Start the activity
            startActivity(intent)
        }

        val profileImageView = view?.findViewById<ImageView>(R.id.profile_image)
        if (profileImageView != null) {
            Glide.with(this)
                .load(User.photoUrl)
                .placeholder(R.drawable.ic_baseline_person_outline_24)
                .into(profileImageView)
        }

        //for stretching card

        val stretchingBtn = view?.findViewById<CircleImageView>(R.id.stretchingTry)

        stretchingBtn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, Stretching::class.java)

            // Start the activity
            startActivity(intent)
        }

        //for weight lifting card

        val cardioTryBtn = view?.findViewById<CircleImageView>(R.id.cardioTry)

        cardioTryBtn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, Cardio::class.java)

            // Start the activity
            startActivity(intent)
        }

        // for squats card
        val squatsBtn = view?.findViewById<CircleImageView>(R.id.squatsTry)

        squatsBtn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, Squats::class.java)

            // Start the activity
            startActivity(intent)
        }



        //for what happens when you loose weight card
        val whatHappensCard = view?.findViewById<CardView>(R.id.whyLoseWeightCard)

        whatHappensCard?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, WhatHappensWeightLoss::class.java)

            // Start the activity
            startActivity(intent)
        }

        //for nutrients for health card
        val nutrientsCard = view?.findViewById<CardView>(R.id.nutritionForHealth)

        nutrientsCard?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, EssentialNutrients::class.java)

            // Start the activity
            startActivity(intent)
        }


        //for weight loss drink card
        val weightLossDrinkimage = view?.findViewById<CardView>(R.id.weightLossDrinkCard)

        weightLossDrinkimage?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, WeightLoss::class.java)

            // Start the activity
            startActivity(intent)
        }




        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}