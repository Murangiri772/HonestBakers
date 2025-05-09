package com.lewishr.honestbakers.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lewishr.honestbakers.data.BakesDatabase
import com.lewishr.honestbakers.model.Bakes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class BakesViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app.applicationContext
    private val bakesDao = BakesDatabase.getDatabase(app).bakesDao()

    val allBakes: LiveData<List<Bakes>> = bakesDao.getAllBakes()

    fun addBakes(name: String, price: Double, imageUri: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val savedImagePath = saveImageToInternalStorage(Uri.parse(imageUri))
            val newBakes = Bakes(
                name = name,
                price = price,

                imagePath = savedImagePath // use saved image path
            )
            bakesDao.insertBakes(newBakes)
        }
    }

    fun updateBakes(updatedBakes: Bakes) {
        viewModelScope.launch(Dispatchers.IO) {
            bakesDao.updateBakes(updatedBakes)
        }
    }

    fun deleteBakes(bakes: Bakes) {
        viewModelScope.launch(Dispatchers.IO) {
            // Delete image from storage
            deleteImageFromInternalStorage(bakes.imagePath)
            bakesDao.deleteBakes(bakes)
        }
    }

    // Save image permanently to internal storage
    private fun saveImageToInternalStorage(uri: Uri): String {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val fileName = "IMG_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)

        inputStream?.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }

        return file.absolutePath
    }

    private fun deleteImageFromInternalStorage(path: String) {
        try {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}