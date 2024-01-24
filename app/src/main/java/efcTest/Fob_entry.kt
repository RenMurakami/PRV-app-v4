package efcTest

import android.Manifest
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.prv_app_v4.R
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.File
import java.io.FileInputStream


class Fob_entry : AppCompatActivity()  {

    private lateinit var coursesGV: GridView

    private var filePath: File = File("")



    private val REQUEST_WRITE_EXTERNAL_STORAGE = 1

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            true
        } else super.onKeyDown(keyCode, event)
    }
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
            Toast.makeText(this@Fob_entry, "Permission (already) Granted!", Toast.LENGTH_SHORT)
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
            Toast.makeText(this@Fob_entry, "Permission (already) Granted!", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun fobEntryExcel(hssfWorkbook: HSSFWorkbook, hssfSheet: HSSFSheet){
        //***********************************************************************************
        //Get Data and insert data
        var hssfRow = hssfSheet.createRow(11)
        var hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Fob Entry")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("Feature List /nResult")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue("Feature List /nCheck")

        hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue("Comments")

        //Next row
        hssfRow = hssfSheet.getRow(12)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Keyless Answer Back Buzzer or Horn")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp0).getSelectedItem().toString())

        //Comment line here
        //hssfCell = hssfRow.createCell(3)
        //hssfCell.setCellValue("Comments")

        //Next row
        hssfRow = hssfSheet.getRow(13)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Door Lock / Unlock")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp1).getSelectedItem().toString())

        //Next row
        hssfRow = hssfSheet.getRow(14)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Welcome Lights")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp2).getSelectedItem().toString())

        //Next row
        hssfRow = hssfSheet.getRow(15)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Door Handle Pop Up")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp3).getSelectedItem().toString())

        //Next row
        hssfRow = hssfSheet.getRow(16)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Power Slide Doors")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp4).getSelectedItem().toString())

        //Next row
        hssfRow = hssfSheet.getRow(17)
        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Power Slide Door Restriction mode (with fuel lid open)")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<Spinner>(R.id.sp5).getSelectedItem().toString())
    }

    private fun updateExcel():Pair<HSSFWorkbook,HSSFSheet>{
        ActivityCompat.requestPermissions(
            this, arrayOf<String>(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ), PackageManager.PERMISSION_GRANTED)

        //showWriteStatePermission()
        //showReadStatePermission()

        //Create Excel
        val docPath=filePath
        val document =  POIFSFileSystem( FileInputStream(docPath));

        val hssfWorkbook = HSSFWorkbook(document)
        val hssfSheet =hssfWorkbook.getSheet("Custom Sheet")

        return Pair(hssfWorkbook,hssfSheet)
    }

    private fun addReasonToExcel(id:String, comment:String){
        val excelData = updateExcel()
        val hssfWorkbook = excelData.first
        val hssfSheet = excelData.second
        var hssfRow = hssfSheet.getRow(0)

        //Comment line here
        when(id){
            "sp0"->hssfRow = hssfSheet.createRow(12)
            "sp1"->hssfRow = hssfSheet.createRow(13)
            "sp2"->hssfRow = hssfSheet.createRow(14)
            "sp3"->hssfRow = hssfSheet.createRow(15)
            "sp4"->hssfRow = hssfSheet.createRow(16)
            "sp5"->hssfRow = hssfSheet.createRow(17)
        }

        var hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue(comment)
        Header_information.saveToExcel(hssfWorkbook, filePath)
    }

    private fun createEmptyReasonEntry(dialogId:String){
        addReasonToExcel(dialogId," ")
    }

    private fun createReasonEntry(dialogId:String){
        //Open popup box to write the reason
        val dialog = Dialog(this@Fob_entry)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pop_up_reason)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val reasonBox:EditText=dialog.findViewById(R.id.reasonBox)
        val reasonLabel:TextView=dialog.findViewById(R.id.reasonLabel)
        val saveButton:TextView=dialog.findViewById(R.id.save)

        dialog.show()

        saveButton.setOnClickListener{
            //Check the data is entered or not.

            //Save the reason in excel
            val reasonString = reasonBox.getText().toString()
                //findViewById<EditText>(R.id.reasonBox).toString()
            addReasonToExcel(dialogId,reasonString)

            dialog.dismiss()
        }
/*
        var abort = findViewById<Button>(R.id.button_abort)
        abort.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

 */
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fob_entry)

        filePath = intent.getSerializableExtra("filePath") as File

        val colors = arrayOf("","OK","NG","N/A","NC")
        val arrayAdp =
            ArrayAdapter(this@Fob_entry,android.R.layout.simple_spinner_dropdown_item,colors)

        val spinner0 =findViewById<Spinner>(R.id.sp0)
        spinner0.adapter = arrayAdp
        spinner0?.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }
                */


                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp0")
                }else{
                    createEmptyReasonEntry("sp0")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
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
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

                 */

                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp1")
                }else{
                    createEmptyReasonEntry("sp1")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
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
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

                 */

                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp2")
                }else{
                    createEmptyReasonEntry("sp2")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
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
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

                 */

                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp3")
                }else{
                    createEmptyReasonEntry("sp3")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
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
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

                 */

                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp4")
                }else{
                    createEmptyReasonEntry("sp4")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
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
                /*
                if("${colors[position]}"==""){
                    Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@Fob_entry,"item is ${colors[position]}",Toast.LENGTH_LONG).show()
                }

                 */

                if( "${colors[position]}" != "OK" &&
                    "${colors[position]}"  != ""  &&
                    "${colors[position]}"  != "N/A" ){
                    //Open popup box to write the reason
                    createReasonEntry("sp5")
                }else{
                    createEmptyReasonEntry("sp5")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@Fob_entry,"Nothing Selected",Toast.LENGTH_LONG).show()
            }
        }

        val buttonNext =findViewById<Button>(R.id.button_next_fob_entry)
        buttonNext.setOnClickListener{
            val excelData = updateExcel()
            val hssfWorkbook = excelData.first
            val hssfSheet = excelData.second
            fobEntryExcel(hssfWorkbook, hssfSheet)
            Header_information.saveToExcel(hssfWorkbook,filePath)

            val intent = Intent(this, EndOfEfc::class.java)
            intent.putExtra("filePath",filePath)

            //Assumption no need to pass the workbook to fob entry

            startActivity(intent)
        }

    }

}