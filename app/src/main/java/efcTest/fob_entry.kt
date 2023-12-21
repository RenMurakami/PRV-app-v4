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

        val colors = arrayOf("","OK","NG","N/A","Hold")
        val arrayAdp =
            ArrayAdapter(this@fob_entry,android.R.layout.simple_spinner_dropdown_item,colors)

        val spinner0 =findViewById<Spinner>(R.id.sp0)
        spinner0.adapter = arrayAdp
        spinner0?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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

        val spinner1 =findViewById<Spinner>(R.id.sp1)
        spinner1.adapter = arrayAdp
        spinner1?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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

        val spinner2 =findViewById<Spinner>(R.id.sp2)
        spinner2.adapter = arrayAdp
        spinner2?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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

        val spinner3 =findViewById<Spinner>(R.id.sp3)
        spinner3.adapter = arrayAdp
        spinner3?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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

        val spinner4 =findViewById<Spinner>(R.id.sp4)
        spinner4.adapter = arrayAdp
        spinner4?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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

        val spinner5 =findViewById<Spinner>(R.id.sp5)
        spinner5.adapter = arrayAdp
        spinner5?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

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