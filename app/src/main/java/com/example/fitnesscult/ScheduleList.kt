package com.example.fitnesscult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ScheduleList : AppCompatActivity() {

    lateinit var scheduleRecyclerView : RecyclerView
    lateinit var scheduleArrayList: ArrayList<ScheduleData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedul_list)

        scheduleRecyclerView = findViewById(R.id.scheduleRecyclerView)

        val scheduleImageArray = arrayOf(
            R.drawable.chris_pratt_workout_routine,
            R.drawable.pushpulllegroutine,
            R.drawable.days3,
            R.drawable.days5,
            R.drawable.days6,
            R.drawable.dayschallenge30,
            R.drawable.twelve_week_workout,
            R.drawable.three_day_full_body,
            R.drawable.three_day_full_body2,
            R.drawable.four_days_for_muscle,
            R.drawable.dumbell_workout,
            R.drawable.matt_damon_workout,
            R.drawable.seven_day_total_body,
            R.drawable.lee_haney_workout,
            R.drawable.repeatable_weekly_workout,
            R.drawable.six_days_push_pull_legs,
            R.drawable.five_days_total_body,
            R.drawable.five_days_split_workout,
            R.drawable.five_days_split_workout_2,
            R.drawable.two_days_split_workout,
            R.drawable.viking_upper_lower_workout,
            R.drawable.four_days_full_body_advance,
            R.drawable.four_week_running_beginner,
            R.drawable.thirty_days_hiit_challenge

            )


        val scheduleHeadingArray = arrayOf(
            "Chris Pratt Workout Routine",
            "Push Pull Leg Routine",
            "3 days workout routine",
            "5 days workout routine",
            "6 days workout routine",
            "30 days workout routine",
            "TWELVE WEEK WORKOUT ROUTINE",
            "THREE DAY FULL BODY ROUTINE",
            "THREE DAY FULL BODY ROUTINE 2",
            "FOUR DAYS ROUTINE FOR MUSCLE BUILDING AND GETTING RIPPED",
            "DUMBBELL WORKOUT",
            "MATT DAMON WORKOUT ROUTINE",
            "SEVEN DAYS TOTAL BODY WORKOUT ROUTINE",
            "LEE HANEY WORKOUT ROUTINE",
            "REPEATABLE WEEKLY WORKOUT",
            "6 DAYS PUSHUP PULLUP LEG WORKOUT",
            "FIVE DAYS TOTAL BODY WORKOUT",
            "FIVE DAYS SPLIT BODY WORKOUT",
            "FIVE DAYS SPLIT BODY WORKOUT 2",
            "TWO DAYS SPLIT BODY WORKOUT",
            "VIKING UPPER LOWER BODY WORKOUT ROUTINE",
            "FOUR DAYS FULL BODY WORKOUT FOR ADVANCE LEVEL",
            "FOUR WEEK RUNNING FOR BEGINNERS",
            "THIRTY DAYS HIIT CHALLENGE"

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