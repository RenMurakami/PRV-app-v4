package com.example.prv_app_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import profilerClass.ProfilerList
import java.io.Serializable


class select_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_profile)

        // This is for start
        val myIntent = intent
        //val obj2= myIntent.getSerializableExtra("object",)

        val tex=findViewById<TextView>(R.id.textView)
        //tex.text=obj2.toString()

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

