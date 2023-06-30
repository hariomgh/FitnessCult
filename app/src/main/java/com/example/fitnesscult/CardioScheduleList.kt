package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardioScheduleList : AppCompatActivity() {

    lateinit var scheduleRecyclerView : RecyclerView
    lateinit var scheduleArrayList: ArrayList<ScheduleData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_schedule_list)


        scheduleRecyclerView = findViewById(R.id.cardioScheduleRecyclerView)

        val scheduleImageArray = arrayOf(

            R.drawable.ten_week_workout_with_cardio,
            R.drawable.cardio_schedule_for_month,
            R.drawable.four_week_cardio_and_strength,
            R.drawable.thirty_day_cardio_challenge,
            R.drawable.daily_cardio,
            R.drawable.fourty_minute_cardio,
            R.drawable.home_cardio,
            R.drawable.twenty_minute_home_cardio

        )


        val scheduleHeadingArray = arrayOf(

            "10 WEEK WORKOUT WITH CARDIO",
            "1 MONTH CARDIO SCHEDULE",
            "FOUR WEEK CARDIO AND STRENGTH SCHEDULE",
            "THIRTY DAY CARDIO CHALLENGE",
            "DAILY CARDIO",
            "40 MINUTES CARDIO ROUTINE",
            "HOME CARDIO EXERCISES",
            "20 MINUTES HOME CARDIO"
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