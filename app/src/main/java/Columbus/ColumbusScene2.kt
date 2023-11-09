package Columbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prv_app_v4.R
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.content.Intent
import com.example.prv_app_v4.MainActivity
import android.util.Log

class ColumbusScene2 : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_columbus_scene2)
        val buttonNext = findViewById<Button>(R.id.button_next)
        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            //val intent = Intent(this, Test_Profile::class.java)
            //startActivity(intent)
            // test
            val countDownTimer = findViewById<TextView>(R.id.countdown)
            val timeCount = countDownTimer.text.toString()
            val second = timeCount.subSequence(6,timeCount.lastIndex+1)
            val minute = timeCount.subSequence(3,5)
            val hour = timeCount.subSequence(0,2)
            val time_in_milisecond = (second.toString().toInt()+60*minute.toString().toInt()
                    +3600*hour.toString().toInt())*1000
            countDownTimer.setVisibility(View.INVISIBLE)
            buttonStart.setVisibility(View.INVISIBLE)
            timer = object: CountDownTimer(time_in_milisecond.toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    //Print remaining time
                    countDownTimer.text = "seconds remaining: " + millisUntilFinished / 1000

                    if (millisUntilFinished < 10000) {
                        countDownTimer.setVisibility(View.VISIBLE)
                        buttonNext.setVisibility(View.VISIBLE)
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


        buttonNext.setOnClickListener{
            val intent = Intent(this,ColumbusIG1::class.java)
            startActivity(intent)
        }

        // THis is for abort
        val buttonAbort = findViewById<Button>(R.id.button_abort)
        buttonAbort.setOnClickListener{
            System.exit(-1)
        }

    }
}


