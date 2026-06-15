package com.example.prismaapp

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap

@Composable
fun StyleTransferScreen(viewModel: MainViewModel) {

    Column {

        Button(onClick = {
            viewModel.runStyleTransfer()
        }) {
            Text("Style Transfer")
        }

        viewModel.resultBitmap?.let { bitmap: Bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Result"
            )
        }
    }
}