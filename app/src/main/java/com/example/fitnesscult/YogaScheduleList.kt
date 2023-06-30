package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class YogaScheduleList : AppCompatActivity() {

    lateinit var scheduleRecyclerView : RecyclerView
    lateinit var scheduleArrayList: ArrayList<ScheduleData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_schedule_list)


        scheduleRecyclerView = findViewById(R.id.yogaScheduleRecyclerView)

        val scheduleImageArray = arrayOf(

            R.drawable.yoga_routine_15_minutes,
            R.drawable.yoga_asana,
            R.drawable.chakra_yoga,
            R.drawable.two_week_yoga_challenge,
            R.drawable.weekly_yoga_schedule,
            R.drawable.yoga_schedules_for_beg_int_adv,
            R.drawable.yoga_and_pilates,
            R.drawable.six_yoga_poses_for_constipation_relief,
            R.drawable.getting_started_with_pilates

        )


        val scheduleHeadingArray = arrayOf(

            "YOGA ROUTINE FOR 15 MINUTES",
            "YOGA ASANA",
            "CHAKRA YOGA ASANA",
            "TWO WEEK YOGA CHALLENGE",
            "WEEKLY YOGA SCHEDULE",
            "YOGA SCHEDULE FOR BEGINNER INTERMEDIATE AND ADVANCE",
            "YOGA AND PILATES",
            "SIX YOGA POSES FOR CONSTIPATION RELIEF",
            "GETTING STARTED WITH PILATES"

        )



        // to set behaviour of items inside recyclerview, vertcially scrolling, horizontally, uniform grid
        scheduleRecyclerView.layoutManager = LinearLayoutManager(this)
        scheduleArrayList = arrayListOf<ScheduleData>()

        for( index in scheduleImageArray.indices){
            val schedules = ScheduleData(scheduleHeadingArray[index], scheduleImageArray[index])
            scheduleArrayList.add(schedules)
        }

        val scheduleAdapter= ScheduleAdapter(scheduleArrayList, this)

        scheduleRecyclerView.adapter = scheduleAdapter
        scheduleAdapter.setOnItemClickListener(object  : ScheduleAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                // what action do we want to perform when we click on wach item

                val intent= Intent(applicationContext, ScheduleDetail::class.java)
                intent.putExtra("imageId", scheduleArrayList[position].scheduleImage)
                startActivity(intent)
            }

        })


    }


}