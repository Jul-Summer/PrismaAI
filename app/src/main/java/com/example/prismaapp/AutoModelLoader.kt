package com.example.prismaapp

import android.content.Context
import android.util.Log
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.channels.FileChannel

object AutoModelLoader {

    fun loadFirstTFLiteModel(context: Context): ByteBuffer? {

        return try {

            val assetManager = context.assets

            val files = assetManager.list("") ?: emptyArray()

            Log.d("AutoModelLoader", "Assets: ${files.joinToString()}")

            val modelName = files.firstOrNull { it.endsWith(".tflite") }

            if (modelName == null) {
                Log.e("AutoModelLoader", "NO TFLITE FOUND")
                return null
            }

            Log.d("AutoModelLoader", "Selected model: $modelName")

            val inputStream = assetManager.open(modelName)
            val fileSize = inputStream.available()

            val buffer = ByteArray(fileSize)
            inputStream.read(buffer)
            inputStream.close()

            ByteBuffer.allocateDirect(fileSize).apply {
                put(buffer)
                rewind()
            }

        } catch (e: Exception) {
            Log.e("AutoModelLoader", "ERROR LOADING MODEL", e)
            null
        }
    }
}