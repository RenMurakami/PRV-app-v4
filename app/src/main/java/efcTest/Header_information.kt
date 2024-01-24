package efcTest

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.prv_app_v4.MainActivity
import com.example.prv_app_v4.R
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class Header_information : AppCompatActivity() {

    private var editTextExcel: EditText? = null



    private var fileName: String=""

    private var filePath: File = File(Environment.getExternalStoragePublicDirectory(Environment.
    DIRECTORY_DOWNLOADS).toString())




    //private var filePath: File = File(Environment.getExternalStorageDirectory().toString() + "/Demo.xls")

    public val REQUEST_WRITE_EXTERNAL_STORAGE = 1

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
            Toast.makeText(this@Header_information, "Permission (already) Granted!", Toast.LENGTH_SHORT)
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
            Toast.makeText(this@Header_information, "Permission (already) Granted!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun createExcel():Pair<HSSFWorkbook,HSSFSheet> {
        ActivityCompat.requestPermissions(
            this, arrayOf<String>(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ), PackageManager.PERMISSION_GRANTED)

        //showWriteStatePermission()
        //showReadStatePermission()
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

        return Pair(hssfWorkbook,hssfSheet)

    }

    private fun createTimestamp():String{
        val currentDateTime: java.util.Date = java.util.Date()
        val currentTimestamp: Long = currentDateTime.time
        return currentTimestamp.toString()
    }

    private fun headerEntryExcel(hssfWorkbook: HSSFWorkbook, hssfSheet: HSSFSheet){
        //Get Data and insert data


        var hssfRow = hssfSheet.createRow(0)
        var hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Data: ")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue(findViewById<EditText>(R.id.date_in).getText().toString())

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue("Model Types: ")

        hssfCell = hssfRow.createCell(4)
        hssfCell.setCellValue(findViewById<EditText>(R.id.model_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(1)

        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Project: ")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue(findViewById<EditText>(R.id.proj_in).getText().toString())

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue("VIN: ")

        hssfCell = hssfRow.createCell(4)
        hssfCell.setCellValue(findViewById<EditText>(R.id.vin_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(2)

        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Lot: ")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue(findViewById<EditText>(R.id.lot_in).getText().toString())

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue("Test Type: ")

        hssfCell = hssfRow.createCell(4)
        hssfCell.setCellValue(findViewById<EditText>(R.id.tester_name_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(3)

        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Unit No.: ")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue(findViewById<EditText>(R.id.vehicle_num_in).getText().toString())

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue("")

        hssfCell = hssfRow.createCell(3)
        hssfCell.setCellValue("PIC: ")

        hssfCell = hssfRow.createCell(4)
        hssfCell.setCellValue(findViewById<EditText>(R.id.tester_credentials_in).getText().toString())

        //Top header done

        //Sub header start

        // Next row
        // skip row 4.
        hssfRow = hssfSheet.createRow(5)

        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Test Temperature: ")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("Ambient")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<EditText>(R.id.ambient_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(6)

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("Cold")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<EditText>(R.id.cold_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(7)

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue("Hot")

        hssfCell = hssfRow.createCell(2)
        hssfCell.setCellValue(findViewById<EditText>(R.id.hot_in).getText().toString())

        // Next row
        hssfRow = hssfSheet.createRow(8)

        hssfCell = hssfRow.createCell(0)
        hssfCell.setCellValue("Frame Code")

        hssfCell = hssfRow.createCell(1)
        hssfCell.setCellValue(findViewById<EditText>(R.id.frameCode_in).getText().toString())

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_information)

        //Create exxcel by click
        /*
        val buttonClick = findViewById<Button>(R.id.click)
        buttonClick.setOnClickListener{
            createExcel()
        }
        */
        val buttonClick = findViewById<Button>(R.id.button_next)
        buttonClick.setOnClickListener{

            val excelData = createExcel()
            val hssfWorkbook = excelData.first
            val hssfSheet = excelData.second
            headerEntryExcel(hssfWorkbook, hssfSheet)

            val currentDateTime: java.util.Date = java.util.Date()
            val currentTimestamp: Long = currentDateTime.time

            fileName=(findViewById<EditText>(R.id.tester_credentials_in).getText().toString())+createTimestamp()
            filePath=File(filePath.path+"/efc_"+fileName+".xls")
            saveToExcel(hssfWorkbook,filePath)



            val intent = Intent(this, Fob_entry::class.java)
            intent.putExtra("filePath",filePath)

            //Assumption no need to pass the workbook to fob entry

            startActivity(intent)
        }

        var abort = findViewById<Button>(R.id.button_abort)
        abort.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        public fun saveToExcel(hssfWorkbook: HSSFWorkbook,filePath:File){

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


    }


}


