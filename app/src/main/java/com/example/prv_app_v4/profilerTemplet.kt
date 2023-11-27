package com.example.prv_app_v4

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import profilerClass.IgProf
import profilerClass.LocationProf
import profilerClass.Profiler
import profilerClass.TimeProf


class profilerTemplet : AppCompatActivity() {
    private lateinit var timer: CountDownTimer

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            true
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiler_templet)

        var mediaPlayer = MediaPlayer.create(this, R.raw.cat1 )
        val myIntent = intent
        // FIXIT
        // ID need to be in logic
        // Does ID need to be different every transmistion?
        // ************************************************
        var keyB = intent.getSerializableExtra("key")
        var selectProf=""
        when (keyB){
            0 -> selectProf = "prof0"
            1 -> selectProf = "prof1"
            2 -> selectProf = "prof2"
            3 -> selectProf = "prof3"
            4 -> selectProf = "prof4"
            5 -> selectProf = "prof5"
        }

        val profilers= intent.getSerializableExtra(selectProf) as Profiler
        // ************************************************
        Log.i(profilers.currentNum.toString(),"CURRENT IS " +profilers.currentNum.toString())

        fun endCondition(): Boolean {
            if (profilers.currentNum > profilers.numProf){
                // END
                var buttonEnd = findViewById<Button>(R.id.button_next)
                buttonEnd.setVisibility(View.VISIBLE)
                var buttonStart = findViewById<Button>(R.id.button_start)
                buttonStart.setVisibility(View.INVISIBLE)

                buttonEnd.setOnClickListener{
                    val intent = Intent(this,end::class.java)
                    startActivity(intent)
                }
                return true
            }else{
                return false
            }
        }

        fun timer(){

        }

        fun audioOn(){
            mediaPlayer.start()
        }

        fun audioOff(){
            mediaPlayer.stop()
        }

        // Set the Button
        var startButton = findViewById<Button>(R.id.button_start)
        startButton.setVisibility(View.VISIBLE)
        var nextButton = findViewById<Button>(R.id.button_next)
        nextButton.setVisibility(View.INVISIBLE)

        var profilerType = profilers.taskList[profilers.currentNum]

        var typeClass = profilerType.javaClass

        var type=""
        if(typeClass.toString() == "class profilerClass.LocationProf"){
            Log.i(typeClass.toString(),"Location")
            type="location"

            var profiler = profilerType as LocationProf

            var topText = findViewById<TextView>(R.id.mainView)
            topText.setText(profiler.text)

            var mainText = findViewById<TextView>(R.id.countdown)
            mainText.setText(profiler.address)
            mainText.setVisibility(View.VISIBLE)

            // Set the Button
            var startButton = findViewById<Button>(R.id.button_start)
            startButton.setVisibility(View.INVISIBLE)
            var nextButton = findViewById<Button>(R.id.button_next)
            nextButton.setVisibility(View.VISIBLE)

            nextButton.setOnClickListener(){
                // Next Activity
                profilers.currentNum = profilers.currentNum+1
                if(!endCondition()){
                    var nextProfiler = profilers.taskList[profilers.currentNum]
                    val intent = Intent(this,profilerTemplet::class.java)
                    intent.putExtra(selectProf, profilers)
                    intent.putExtra("key", keyB)
                    startActivity(intent)
                }

            }

        }else if(typeClass.toString() == "class profilerClass.IgProf"){
            Log.i(typeClass.toString(),"IG")
            type="ig"

            var profiler = profilerType as IgProf

            var topText = findViewById<TextView>(R.id.mainView)
            topText.setText(profiler.text)

            var countDownTimer = findViewById<TextView>(R.id.countdown)
            countDownTimer.setText(profiler.time)

            startButton.setOnClickListener(){


                val timeCount = countDownTimer.text.toString()
                val second = timeCount.subSequence(6,timeCount.lastIndex+1)
                val minute = timeCount.subSequence(3,5)
                val hour = timeCount.subSequence(0,2)
                val time_in_milisecond = (second.toString().toInt()+60*minute.toString().toInt()
                        +3600*hour.toString().toInt())*1000
                countDownTimer.setVisibility(View.INVISIBLE)
                startButton.setVisibility(View.INVISIBLE)
                timer = object: CountDownTimer(time_in_milisecond.toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        //Print remaining time
                        countDownTimer.text = "seconds remaining: " + millisUntilFinished / 1000

                        if (millisUntilFinished < 10000) {
                            countDownTimer.setVisibility(View.VISIBLE)
                            nextButton.setVisibility(View.VISIBLE)
                            audioOn()
                        }
                    }
                    override fun onFinish() {
                        //Print timer completion statement
                        countDownTimer.text = "Complete"
                        //buttonStart.setVisibility(View.VISIBLE)
                    }
                }
                timer.start()

            }

            nextButton.setOnClickListener {
                // Next Activity
                audioOff()
                profilers.currentNum = profilers.currentNum+1
                if (!endCondition()){
                    var nextProfiler = profilers.taskList[profilers.currentNum]
                    val intent = Intent(this,profilerTemplet::class.java)
                    intent.putExtra(selectProf, profilers)
                    intent.putExtra("key", keyB)
                    startActivity(intent)
                }

            }


        }else if(typeClass.toString() == "class profilerClass.TimeProf"){
            Log.i(typeClass.toString(),"Time")
            type="time"

            var profiler = profilerType as TimeProf

            var topText = findViewById<TextView>(R.id.mainView)
            topText.setText(profiler.text)

            var countDownTimer = findViewById<TextView>(R.id.countdown)
            countDownTimer.setText(profiler.time)

            startButton.setOnClickListener(){


                val timeCount = countDownTimer.text.toString()
                val second = timeCount.subSequence(6,timeCount.lastIndex+1)
                val minute = timeCount.subSequence(3,5)
                val hour = timeCount.subSequence(0,2)
                val time_in_milisecond = (second.toString().toInt()+60*minute.toString().toInt()
                        +3600*hour.toString().toInt())*1000
                countDownTimer.setVisibility(View.INVISIBLE)
                startButton.setVisibility(View.INVISIBLE)
                timer = object: CountDownTimer(time_in_milisecond.toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        //Print remaining time
                        countDownTimer.text = "seconds remaining: " + millisUntilFinished / 1000

                        if (millisUntilFinished < 10000) {
                            countDownTimer.setVisibility(View.VISIBLE)
                            nextButton.setVisibility(View.VISIBLE)
                            audioOn()
                        }
                    }
                    override fun onFinish() {
                        //Print timer completion statement
                        countDownTimer.text = "Complete"
                        //buttonStart.setVisibility(View.VISIBLE)
                    }
                }
                timer.start()

            }

            nextButton.setOnClickListener {
                // Next Activity
                audioOff()
                profilers.currentNum = profilers.currentNum+1
                if(!endCondition()){
                    var nextProfiler = profilers.taskList[profilers.currentNum]
                    val intent = Intent(this,profilerTemplet::class.java)
                    intent.putExtra(selectProf, profilers)
                    intent.putExtra("key", keyB)
                    startActivity(intent)
                }
            }


        } else{
            Log.i(typeClass.toString(),typeClass.toString()+ " POTENTIAL ISSUE")
            type="error"
        }

        var abort = findViewById<Button>(R.id.button_abort)
        abort.setOnClickListener{
            audioOff()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}