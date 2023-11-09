package com.example.prv_app_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class select_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_profile)

        // This is for start

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

