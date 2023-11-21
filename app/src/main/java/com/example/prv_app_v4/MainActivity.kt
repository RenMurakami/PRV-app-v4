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
import profilerClass.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        * This section will be the section to
        * initialize the profiler sets.
        * ProfilerList() will contain multiple profiler sets.
        * This will display in the select profiler activity.
        * Example will be Columbus route, 4 Hours Drive or something like that.
        * Profiler
        *
        *
        *
        *
         */
        // Create the profiler set
        val profiler = ProfilerList()
        // The title for the start screen.
        profiler.title="PRV Application"

        // Create the first Profiler
        var columbusRout = Profiler()
        columbusRout.name="Columbus~Route"
        columbusRout.numProf=3

        // 1 st task
        var c0=LocationProf()
        c0.index=0
        c0.text="Go to cat colony\n and fluff cats"
        c0.address="2740 Festival Ln,\n Dublin, OH 43017"

        // 2 st task
        var c1=TimeProf()
        c1.index=1
        c1.text="Time off for 5 seconds"
        c1.time="00:00:5"

        // 3 st task
        var c2=TimeProf()
        c2.index=2
        c2.text="Drive for 13 seconds"
        c2.time="00:00:13"

        var c3=TimeProf()
        c3.index=3
        c3.text="Drive for 11 seconds"
        c3.time="00:00:11"

        // Adding those task in Columbus route
        // Every task you create need to be added here
        columbusRout.taskList.add(c0)
        columbusRout.taskList.add(c1)
        columbusRout.taskList.add(c2)
        columbusRout.taskList.add(c3)
        // '''

        //
        profiler.profilerList.add(columbusRout)

        // Create the first Profiler
        var emptyRoute = Profiler()
        emptyRoute.name="EMPTY~Route"
        emptyRoute.numProf=0

        profiler.profilerList.add(emptyRoute)



        val text =findViewById<TextView>(R.id.textView)
        text.text=profiler.title

        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            val intent = Intent(this,select_profile::class.java)
            intent.putExtra("object", profiler)
            startActivity(intent)
        }


    }
}