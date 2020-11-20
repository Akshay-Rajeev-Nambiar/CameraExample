package com.example.cameraexample

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cameraexample.adapter.GalleryAdapter
import kotlinx.android.synthetic.main.activity_gallery.*
import java.io.File
import java.lang.Exception

class GalleryActivity : AppCompatActivity() {
    private lateinit var imageFile: File
    private val filePathList = mutableListOf<String>()
    lateinit var photoFile : File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        try {
            imageFile = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!.path)
            for(i in imageFile.list().indices){
                photoFile = File(imageFile.path + "/" + imageFile.list()[i])
                filePathList.add(photoFile.absolutePath)
            }
            gallery_rv.layoutManager = LinearLayoutManager(this)
            gallery_rv.adapter = GalleryAdapter(filePathList)
        }
        catch (e : Exception){
            Toast.makeText(this,"Empty Folder !!",Toast.LENGTH_SHORT).show()
        }
    }
}