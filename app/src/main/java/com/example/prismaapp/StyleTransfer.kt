package com.example.prismaapp

import android.graphics.Bitmap

class StyleTransfer(
    private val model: TFLiteModel
) {

    fun apply(bitmap: Bitmap): Bitmap {

        val input = ImageUtils.preprocess(bitmap)

        val output = model.run(input)

        return ImageUtils.postprocess(output)
    }
}