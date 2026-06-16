package com.example.prismaapp

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _input = MutableStateFlow<Bitmap?>(null)
    val input = _input.asStateFlow()

    private val _output = MutableStateFlow<Bitmap?>(null)
    val output = _output.asStateFlow()

    fun setInput(bitmap: Bitmap) {
        _input.value = bitmap
    }

    fun setOutput(bitmap: Bitmap) {
        _output.value = bitmap
    }

    // ✅ ВАЖНО
    fun runStyle(styleTransfer: StyleTransfer) {

        val bitmap = _input.value ?: return

        val result = styleTransfer.apply(bitmap)

        _output.value = result
    }
}