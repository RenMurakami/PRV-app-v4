package com.example.prv_app_v4


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.IOException
import java.io.InputStreamReader
import java.sql.Types.NULL


class Setting : AppCompatActivity() {
    //var filePath=data?.data?.path
    public var filePath=""
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 777) {
            filePath = data?.data.toString()
        }
    }



    fun openFolder(location: String) {
        // location = "/sdcard/my_folder";
        /*
        val path =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
        val uri = Uri.parse(path)
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.setDataAndType(uri, "*//*")
        startActivity(intent)
        */
        val intent = Intent()
            .setType("*/*")
            .setAction(Intent.ACTION_GET_CONTENT)

        startActivityForResult(Intent.createChooser(intent, "Select a file"), 777)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val loadButton =findViewById<Button>(R.id.takeInput)
        loadButton.setOnClickListener{
            openFolder("")
            //File Path Fix
            // content://com.android.providers.downloads.documents/document/msf%3A4807
            val index:Int = filePath.indexOf("/", startIndex = 54)
            if(index>0){

                filePath = filePath.subSequence(0,index+1).toString()
                filePath += "param.yaml"

                Log.i(filePath,filePath)
                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput(filePath)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                //Displaying data on EditText

                val fileData = findViewById<TextView>(R.id.testOut)
                fileData.setText(stringBuilder.toString()).toString()
            }
            // onActivityResult will be excecuted here. It is a bit too late. There might be more
            // applicable function to override. It might even does not need to override.

        }

    }


}