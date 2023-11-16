package com.example.prv_app_v4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.prv_app_v4.databinding.ActivityMainBinding
import profilerClass.ProfilerList
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val obj = ProfilerList()
        obj.Title="UNI"
        val text =findViewById<TextView>(R.id.textView)
        text.text=obj.Title

        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            val intent = Intent(this,select_profile::class.java)
            intent.putExtra("object", obj)
            startActivity(intent)
        }


    }
}