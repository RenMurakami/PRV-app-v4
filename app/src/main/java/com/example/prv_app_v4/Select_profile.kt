package com.example.prv_app_v4

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import efcTest.Header_information
import profiler.ProfilerList


class Select_profile : AppCompatActivity() {
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            true
        } else super.onKeyDown(keyCode, event)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_profile)



        // This is for start
        val myIntent = intent
        val profiler= intent.getSerializableExtra("object") as ProfilerList

        var numActiveButton=0
        for (n in profiler.profilerList){

            var but=findViewById<Button>(R.id.button_start0)
            when (numActiveButton){
                0 -> but = findViewById<Button>(R.id.button_start0)
                1 -> but = findViewById<Button>(R.id.button_start1)
                2 -> but = findViewById<Button>(R.id.button_start2)
                3 -> but = findViewById<Button>(R.id.button_start3)
                4 -> but = findViewById<Button>(R.id.button_start4)
                5 -> but = findViewById<Button>(R.id.button_start5)
            }
            but.setText(n.name)
            but.setVisibility(View.VISIBLE)
            numActiveButton++
        }


        //Columbus profiler
        val buttonStart0 = findViewById<Button>(R.id.button_start0)
        buttonStart0.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof0", profiler.profilerList[0])
            intent.putExtra("key", 0)
            startActivity(intent)
        }

        val buttonStart1 = findViewById<Button>(R.id.button_start1)
        buttonStart1.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof1", profiler.profilerList[1])
            intent.putExtra("key", 1)
            startActivity(intent)
        }

        val buttonStart2 = findViewById<Button>(R.id.button_start2)
        buttonStart2.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof2", profiler.profilerList[2])
            intent.putExtra("key", 2)
            startActivity(intent)
        }

        val buttonStart3 = findViewById<Button>(R.id.button_start3)
        buttonStart3.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof3", profiler.profilerList[3])
            intent.putExtra("key", 3)
            startActivity(intent)
        }

        val buttonStart4 = findViewById<Button>(R.id.button_start4)
        buttonStart4.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof4", profiler.profilerList[4])
            intent.putExtra("key", 4)
            startActivity(intent)
        }

        val buttonStart5 = findViewById<Button>(R.id.button_start5)
        buttonStart5.setOnClickListener{
            val intent = Intent(this,ProfilerTemplet::class.java)
            intent.putExtra("prof5", profiler.profilerList[5])
            intent.putExtra("key", 5)
            startActivity(intent)
        }

        val buttonStart6 = findViewById<Button>(R.id.button_start6)
        buttonStart6.setOnClickListener{
            val intent = Intent(this,Header_information::class.java)
            //intent.putExtra("prof5", profiler.profilerList[5])
            //intent.putExtra("key", 6)
            startActivity(intent)
        }




        // THis is for abort
        val buttonAbort = findViewById<Button>(R.id.button_abort)
        buttonAbort.setOnClickListener{
            System.exit(-1)
        }

    }


}

