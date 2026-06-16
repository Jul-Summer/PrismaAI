package com.example.prismaapp

import android.graphics.Bitmap
import java.nio.ByteBuffer
import java.nio.ByteOrder

object ImageUtils {

    fun preprocess(bitmap: Bitmap): ByteBuffer {

        val resized = Bitmap.createScaledBitmap(bitmap, 256, 256, true)

        val input = ByteBuffer.allocateDirect(1 * 256 * 256 * 3 * 4)
        input.order(ByteOrder.nativeOrder())

        val pixels = IntArray(256 * 256)
        resized.getPixels(pixels, 0, 256, 0, 0, 256, 256)

        for (pixel in pixels) {
            val r = ((pixel shr 16) and 0xFF) / 255f
            val g = ((pixel shr 8) and 0xFF) / 255f
            val b = (pixel and 0xFF) / 255f

            input.putFloat(r)
            input.putFloat(g)
            input.putFloat(b)
        }

        input.rewind()
        return input
    }

    fun postprocess(output: ByteBuffer): Bitmap {

        output.rewind()

        val pixels = IntArray(256 * 256)

        for (i in pixels.indices) {
            val r = (output.float * 255).toInt().coerceIn(0, 255)
            val g = (output.float * 255).toInt().coerceIn(0, 255)
            val b = (output.float * 255).toInt().coerceIn(0, 255)

            pixels[i] = (0xFF shl 24) or (r shl 16) or (g shl 8) or b
        }

        return Bitmap.createBitmap(pixels, 256, 256, Bitmap.Config.ARGB_8888)
    }
}