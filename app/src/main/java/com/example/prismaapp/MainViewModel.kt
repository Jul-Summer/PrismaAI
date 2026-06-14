package com.example.prismaapp

import android.app.Application
import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val model = TFLiteModel(application)

    var resultBitmap by mutableStateOf<Bitmap?>(null)
        private set

    fun runStyleTransfer(input: Bitmap) {
        resultBitmap = StyleTransfer(model.interpreter).run(input)
    }
}
