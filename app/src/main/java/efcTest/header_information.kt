package efcTest

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.prv_app_v4.R
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class header_information : AppCompatActivity() {
    private var editTextExcel: EditText? = null
    //private var filePath: File = File(Environment.getExternalStorageDirectory().toString() + "/Demo.xls")
    private var filePath: File = File(Environment.getExternalStoragePublicDirectory(Environment.
                                    DIRECTORY_DOWNLOADS).toString()+ "/Demo.xls")
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
            Toast.makeText(this@header_information, "Permission (already) Granted!", Toast.LENGTH_SHORT)
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
            Toast.makeText(this@header_information, "Permission (already) Granted!", Toast.LENGTH_SHORT)
                .show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_information)

        ActivityCompat.requestPermissions(
            this, arrayOf<String>(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ), PackageManager.PERMISSION_GRANTED)




        //showWriteStatePermission()
        //showReadStatePermission()

        editTextExcel = findViewById(R.id.date_in);

        val buttonClick = findViewById<Button>(R.id.click)
        buttonClick.setOnClickListener{

            val hssfWorkbook = HSSFWorkbook()
            val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

            val hssfRow = hssfSheet.createRow(0)
            val hssfCell = hssfRow.createCell(0)

            hssfCell.setCellValue(findViewById<EditText>(R.id.date_in).getText().toString())

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