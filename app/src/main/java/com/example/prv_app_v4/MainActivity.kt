package com.example.prv_app_v4

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prv_app_v4.databinding.ActivityMainBinding
import profiler.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            true
        } else super.onKeyDown(keyCode, event)
    }



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
        profiler.inputFile=false
//--------------------------------------------------------------------------------------------
        // Create the first Profiler
        var columbusRout = Profiler()
        columbusRout.name="Columbus~Route"
        columbusRout.numProf=4

        // 1 st task
        var c0=LocationProf()
        c0.index=0
        c0.text="Go to cat colony\n and fluff cats"
        c0.address="2740 Festival Ln,\n Dublin, OH 43017"

        // 2 st task
        var c1=TimeProf()
        c1.index=1
        c1.text="Time off for 5 seconds"
        c1.time="00:00:05"

        // 3 st task
        var c2=TimeProf()
        c2.index=2
        c2.text="Drive for 13 seconds"
        c2.time="00:00:13"

        var c3=TimeProf()
        c3.index=3
        c3.text="Drive for 11 seconds"
        c3.time="00:00:11"

        var c4 =IgProf()
        c4.index=4
        c4.text="IG off for 11 seconds"
        c4.time="00:00:11"

        // Adding those task in Columbus route
        // Every task you create need to be added here
        columbusRout.taskList.add(c0)
        columbusRout.taskList.add(c1)
        columbusRout.taskList.add(c2)
        columbusRout.taskList.add(c3)
        columbusRout.taskList.add(c4)
        // '''

        //
        profiler.profilerList.add(columbusRout)
//--------------------------------------------------------------------------------------------
        // Create Random IG Cycle Profiler
        var igCycle = Profiler()
        igCycle.name = "IG Cycle~Route"
        igCycle.numProf=1

        var i4 = IgProf()
        i4.index = 0
        i4.text = "IG Cycle for 10 seconds"
        i4.time = "00:00:10"

        //5 st task
        var i5 = IgProf()
        i5.index = 1
        i5.text = "IG Cycle for 13 seconds"
        i5.time = "00:00:13"

        //Add tasks to IGCycle Route
        igCycle.taskList.add(i4)
        igCycle.taskList.add(i5)


        //Add Route to List
        profiler.profilerList.add(igCycle)
//--------------------------------------------------------------------------------------------
        // Create blank Profiler
        var emptyRoute = Profiler()
        emptyRoute.name="EMPTY~Route"
        emptyRoute.numProf=0

        profiler.profilerList.add(emptyRoute)



        val text =findViewById<TextView>(R.id.textView)
        text.text=profiler.title

        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener{
            val intent = Intent(this,Select_profile::class.java)
            intent.putExtra("object", profiler)
            startActivity(intent)
        }

        val buttonSetting = findViewById<Button>(R.id.buttonSetting)
        buttonSetting.setOnClickListener {
            val intent = Intent(this,Setting::class.java)
            intent.putExtra("object", profiler)
            startActivity(intent)
        }


    }
}