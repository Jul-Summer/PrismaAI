package com.example.prismaapp

import android.app.Application
import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val model = TFLiteModel(application, "G_A2B.tflite")
    private val style = StyleTransfer(model)

    var resultBitmap by mutableStateOf<Bitmap?>(null)
        private set

    fun runStyleTransfer() {

        val input = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888)

        resultBitmap = style.run(input)
    }
}