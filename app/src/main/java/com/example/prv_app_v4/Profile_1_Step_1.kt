package com.example.prv_app_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class Profile_1_Step_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile1_step1)

        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            val Intent = Intent(this,Test_Profile::class.java)
            startActivity(Intent)
        }
    }
}