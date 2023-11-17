package com.example.prv_app_v4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import profilerClass.ProfilerList
import java.sql.Types.NULL


class select_profile : AppCompatActivity() {
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
        val buttonStart = findViewById<Button>(R.id.button_start0)
        buttonStart.setOnClickListener{
            val intent = Intent(this,Columbus.ColumbusScene1::class.java)
            startActivity(intent)
        }

        // THis is for abort
        val buttonAbort = findViewById<Button>(R.id.button_abort)
        buttonAbort.setOnClickListener{
            System.exit(-1)
        }

    }


}

