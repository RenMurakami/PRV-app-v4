package com.example.prv_app_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class Test_Profile : AppCompatActivity() {

    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_profile)

        val textView = findViewById<TextView>(R.id.countdown)
        val buttonStart = findViewById<Button>(R.id.button_start)

        //Count Down object
        timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //Print remaining time
                textView.text = "seconds remaining: " + millisUntilFinished / 1000

                if (millisUntilFinished < 10000) {
                    textView.setVisibility(View.VISIBLE)
                    buttonStart.setVisibility(View.VISIBLE)
                }

            }

            override fun onFinish() {
                //Print timer completion statement
                textView.text = "Complete"
                //buttonStart.setVisibility(View.VISIBLE)
            }
        }

        buttonStart.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        //run timer on entering screen
        timer.start()
    }

    override fun onStop() {
        super.onStop()
        //stop timer count when completed
        timer.cancel()
    }

}