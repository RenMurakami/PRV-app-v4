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
        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            val Intent = Intent(this,Profile_1_Step_1::class.java)
            startActivity(Intent)
        }

        // THis is for abort
        val buttonAbort = findViewById<Button>(R.id.button_abort)
        buttonAbort.setOnClickListener{
            System.exit(-1)
        }

    }


}

