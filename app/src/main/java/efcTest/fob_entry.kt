package efcTest

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.prv_app_v4.R
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class fob_entry : AppCompatActivity()  {

    private lateinit var coursesGV: GridView

    private var filePath: File = File(Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS).toString()+ "/Demo.xls")
    private val REQUEST_WRITE_EXTERNAL_STORAGE = 1

    private fun showExplanation(
        title: String,
        message: String,
        permission: String,
        permissionRequestCode: Int
    ) {
        //This might be an issue.
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, id ->
                    requestPermission(
                        permission,
                        permissionRequestCode
                    )
                })
        builder.create().show()
    }

    private fun requestPermission(permissionName: String, permissionRequestCode: Int) {
        ActivityCompat.requestPermissions(this, arrayOf(permissionName), permissionRequestCode)
    }

    private fun showWriteStatePermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                showExplanation(
                    "Permission Needed",
                    "Rationale",
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    REQUEST_WRITE_EXTERNAL_STORAGE
                )
            } else {
                requestPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    REQUEST_WRITE_EXTERNAL_STORAGE
                )
            }
        } else {
            Toast.makeText(this@fob_entry, "Permission (already) Granted!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun showReadStatePermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this, Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
                showExplanation(
                    "Permission Needed",
                    "Rationale",
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    REQUEST_WRITE_EXTERNAL_STORAGE
                )
            } else {
                requestPermission(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    REQUEST_WRITE_EXTERNAL_STORAGE
                )
            }
        } else {
            Toast.makeText(this@fob_entry, "Permission (already) Granted!", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun createExcel(){
        ActivityCompat.requestPermissions(
            this, arrayOf<String>(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ), PackageManager.PERMISSION_GRANTED)

        //showWriteStatePermission()
        //showReadStatePermission()

        //Create Excel
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

        //***********************************************************************************
        //Get Data and insert data
        val r0 = hssfSheet.createRow(0)
        val c0_0 = r0.createCell(0)
        c0_0.setCellValue("Keyless Answer Back \\nBuzzer or Horn")

        //val r0 = hssfSheet.createRow(0)
        val c0_1 = r0.createCell(1)
        c0_1.setCellValue(findViewById<Spinner>(R.id.sp0).getSelectedItem().toString())

        //**********************

        val r1 = hssfSheet.createRow(1)
        val c1_0 = r1.createCell(0)
        c1_0.setCellValue("Door Lock / Unlock")

        //val r0 = hssfSheet.createRow(0)
        val c1_1 = r1.createCell(1)
        c1_1.setCellValue(findViewById<Spinner>(R.id.sp1).getSelectedItem().toString())

        //**********************

        val r2 = hssfSheet.createRow(2)
        val c2_0 = r2.createCell(0)
        c2_0.setCellValue("Welcome Lights")

        //val r0 = hssfSheet.createRow(0)
        val c2_1 = r2.createCell(1)
        c2_1.setCellValue(findViewById<Spinner>(R.id.sp2).getSelectedItem().toString())

        //***********************************************************************************


        //Write to excel file
        try {
            if (!filePath.exists()) {
                //filePath= File(getExternalStorageDirectory().toString() + "/Demo.xls")
                filePath.createNewFile()
            }
            val fileOutputStream = FileOutputStream(filePath)
            hssfWorkbook.write(fileOutputStream)
            if (fileOutputStream != null) {
                fileOutputStream.flush()
                fileOutputStream.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            e.toString()
            e.cause.toString()
        }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fob_entry)

        val colors = arrayOf("","OK","NG","N/A","NC")
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

        val buttonNext =findViewById<Button>(R.id.button_next_fob_entry)
        buttonNext.setOnClickListener{
            createExcel()

        }


    }

}