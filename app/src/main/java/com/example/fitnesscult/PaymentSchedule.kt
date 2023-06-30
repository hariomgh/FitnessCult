package com.example.fitnesscult

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class PaymentSchedule : AppCompatActivity() , PaymentResultListener {


    private val editAmount = 50 // INR 50

    lateinit var btnPay:Button

    lateinit var paymentStatus:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_schedule)



        btnPay=findViewById(R.id.btn_pay)

        paymentStatus=findViewById(R.id.payment_status)

        //for shared preferences

        val prefs = getSharedPreferences("payment_prefs", Context.MODE_PRIVATE)
        val isPaid = prefs.getBoolean("is_paid", false)

        if (isPaid) {
            // Payment already made, go directly to ScheduleList
            val intent = Intent(this@PaymentSchedule, ScheduleTypes::class.java)
            startActivity(intent)
            finish()
        } else {
            // Payment not yet made, show payment activity
            btnPay.setOnClickListener {
                paymentProcess()
            }
            Checkout.preload(this@PaymentSchedule)
        }

    }



    private fun paymentProcess() {

        val checkout=Checkout()


        checkout.setKeyID("rzp_test_PUboK8A8FPqOQA")

        try {


            val options=JSONObject()

            options.put("name","FitnessCult Premium Schedules")

            options.put("description","Make a payment")

            options.put("image","https://images.template.net/wp-content/uploads/2015/10/07223137/My-Workout-Schedule-Template-Free-Download.jpg")

            options.put("theme.color","#528FF0")

            options.put("currency","INR")

//            options.put("amount",amount*100)
            options.put("amount", 5000)

            val retryObj=JSONObject()


            retryObj.put("enabled",true)

            retryObj.put("max_count",4)

            options.put("retry",retryObj)



            checkout.open(this@PaymentSchedule,options)
        }
        catch (e:Exception){

            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        }



    }


    override fun onPaymentSuccess(p0: String?) {


        paymentStatus.text=p0

        paymentStatus.setTextColor(Color.GREEN)

        // Updating the payment status in SharedPreferences
        val prefs = getSharedPreferences("payment_prefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("is_paid", true).apply()


        Handler().postDelayed({
            val intent = Intent(this@PaymentSchedule, ScheduleTypes::class.java)
            startActivity(intent)
            finish()
        }, 2000)


    }

    override fun onPaymentError(p0: Int, p1: String?) {

        paymentStatus.text=p1

        paymentStatus.setTextColor(Color.RED)

    }
}