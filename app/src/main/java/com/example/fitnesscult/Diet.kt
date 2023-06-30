package com.example.fitnesscult

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Diet.newInstance] factory method to
 * create an instance of this fragment.
 */
class Diet : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_diet, container, false)

        val diet1Btn = view?.findViewById<CardView>(R.id.diet1Card)

        diet1Btn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, Diet1::class.java)

            // Start the activity
            startActivity(intent)
        }

        val diet2Btn = view?.findViewById<CardView>(R.id.diet2Card)

        diet2Btn?.setOnClickListener {
            // Create a new intent to start the activity
            val intent = Intent(activity, Diet2::class.java)

            // Start the activity
            startActivity(intent)
        }

//        val tryMoreBtn = view?.findViewById<CardView>(R.id.tryMoreCard)
//
//        tryMoreBtn?.setOnClickListener {
//            // Create a new intent to start the activity
//            val intent = Intent(activity, MoreDiet::class.java)
//
//            // Start the activity
//            startActivity(intent)
//        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Diet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Diet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}