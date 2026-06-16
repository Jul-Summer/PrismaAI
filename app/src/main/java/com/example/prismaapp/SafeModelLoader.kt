package com.example.prismaapp

import android.content.Context
import android.util.Log
import java.io.FileInputStream
import java.io.IOException
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

object SafeModelLoader {

    private const val TAG = "SafeModelLoader"

    fun loadModel(
        context: Context,
        modelName: String
    ): MappedByteBuffer? {

        return try {

            val assets = context.assets

            // 🔥 1. CHECK IF FILE EXISTS
            val files = assets.list("") ?: emptyArray()

            if (!files.contains(modelName)) {
                Log.e(TAG, "❌ Model not found in assets: $modelName")
                Log.e(TAG, "📁 Available files: ${files.joinToString()}")
                return null
            }

            // 🔥 2. LOAD FILE SAFELY
            val fileDescriptor = assets.openFd(modelName)

            val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
            val fileChannel = inputStream.channel

            val buffer = fileChannel.map(
                FileChannel.MapMode.READ_ONLY,
                fileDescriptor.startOffset,
                fileDescriptor.declaredLength
            )

            Log.d(TAG, "✅ Model loaded successfully: $modelName")

            buffer

        } catch (e: IOException) {
            Log.e(TAG, "❌ Failed to load model", e)
            null
        } catch (e: Exception) {
            Log.e(TAG, "❌ Unexpected error loading model", e)
            null
        }
    }
}