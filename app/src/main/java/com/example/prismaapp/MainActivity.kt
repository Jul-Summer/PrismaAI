package com.example.prismaapp

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import org.tensorflow.lite.Interpreter

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var styleTransfer: StyleTransfer

    // ✅ IMAGE PICKER
    private val pickImage =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->

            if (uri == null) {
                Log.e("VM", "URI IS NULL")
                return@registerForActivityResult
            }

            try {
                Log.d("VM", "URI = $uri")

                val bitmap = contentResolver.openInputStream(uri)?.use { stream ->
                    BitmapFactory.decodeStream(stream)
                }

                if (bitmap != null) {
                    viewModel.setInput(bitmap)
                    Log.d("VM", "IMAGE LOADED SUCCESS")
                } else {
                    Log.e("VM", "BITMAP IS NULL")
                }

            } catch (e: Exception) {
                Log.e("VM", "ERROR LOADING IMAGE", e)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔥 FIXED MODEL LOADING (NO CRASH)
        val modelBuffer = AutoModelLoader.loadFirstTFLiteModel(this)

        if (modelBuffer == null) {
            Log.e("MODEL", "MODEL NOT LOADED - check assets")
            return   // ❌ больше НИКАКИХ crash
        }

        val interpreter = Interpreter(modelBuffer)

        styleTransfer = StyleTransfer(TFLiteModel(interpreter))

        setContent {

            StyleTransferScreen(
                viewModel = viewModel,

                onPickImage = {
                    Log.d("VM", "PICK IMAGE CLICKED")
                    pickImage.launch(arrayOf("image/*"))
                },

                onRunStyle = {
                    Log.d("VM", "RUN CLICKED")

                    val input = viewModel.input.value

                    if (input == null) {
                        Log.e("VM", "NO IMAGE SELECTED")
                        return@StyleTransferScreen
                    }

                    viewModel.runStyle(styleTransfer)
                }
            )
        }
    }
}