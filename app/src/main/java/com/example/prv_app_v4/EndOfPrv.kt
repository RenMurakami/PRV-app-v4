package com.example.prv_app_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EndOfPrv : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val buttonStart = findViewById<Button>(R.id.endButton)
        buttonStart.setOnClickListener{
                val Intent = Intent(this,MainActivity::class.java)
                startActivity(Intent)
            }
    }
}