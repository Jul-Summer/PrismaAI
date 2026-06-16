package com.example.prismaapp

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.asImageBitmap

@Composable
fun StyleTransferScreen(
    viewModel: MainViewModel,
    onPickImage: () -> Unit,
    onRunStyle: () -> Unit
) {

    val input by viewModel.input.collectAsState()
    val output by viewModel.output.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {

        Button(onClick = onPickImage) {
            Text("Pick Image")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onRunStyle) {
            Text("Run Style Transfer")
        }

        Spacer(modifier = Modifier.height(12.dp))

        input?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "input",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        output?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "output",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        }
    }
}