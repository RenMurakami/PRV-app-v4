package efcTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Spinner
import android.widget.Toast
import com.example.prv_app_v4.R


class fob_entry : AppCompatActivity()  {

    private lateinit var coursesGV: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fob_entry)

        val spinnerId =findViewById<Spinner>(R.id.sp0)

        val colors = arrayOf("","OK","NG","N/A","Hold")
        val arrayAdp =
            ArrayAdapter(this@fob_entry,android.R.layout.simple_spinner_dropdown_item,colors)
        spinnerId.adapter = arrayAdp

        spinnerId?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if("${colors[position]}"==""){
                    Toast.makeText(this@fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
            }
        }

    }

}