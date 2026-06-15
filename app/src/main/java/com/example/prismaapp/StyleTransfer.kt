package com.example.prismaapp

import android.graphics.Bitmap
import android.graphics.Color

class StyleTransfer(private val model: TFLiteModel) {

    fun run(input: Bitmap): Bitmap {

        val tensor = ImageUtils.bitmapToByteBuffer(input)

        val output = Array(1) {
            Array(256) {
                Array(256) {
                    FloatArray(3)
                }
            }
        }

        model.interpreter.run(tensor, output)

        return convertToBitmap(output)
    }

    private fun convertToBitmap(
        output: Array<Array<Array<FloatArray>>>
    ): Bitmap {

        val bmp = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888)

        for (y in 0 until 256) {
            for (x in 0 until 256) {

                val r = (output[0][y][x][0] * 255).toInt().coerceIn(0, 255)
                val g = (output[0][y][x][1] * 255).toInt().coerceIn(0, 255)
                val b = (output[0][y][x][2] * 255).toInt().coerceIn(0, 255)

                bmp.setPixel(x, y, Color.rgb(r, g, b))
            }
        }

        return bmp
    }
}