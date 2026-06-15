package com.example.prismaapp

import android.graphics.Bitmap
import java.nio.ByteBuffer
import java.nio.ByteOrder

object ImageUtils {

    fun bitmapToByteBuffer(bitmap: Bitmap, size: Int = 256): ByteBuffer {

        val resized = Bitmap.createScaledBitmap(bitmap, size, size, true)

        val buffer = ByteBuffer.allocateDirect(4 * size * size * 3)
        buffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(size * size)
        resized.getPixels(pixels, 0, size, 0, 0, size, size)

        for (pixel in pixels) {
            val r = (pixel shr 16 and 0xFF) / 255.0f
            val g = (pixel shr 8 and 0xFF) / 255.0f
            val b = (pixel and 0xFF) / 255.0f

            buffer.putFloat(r)
            buffer.putFloat(g)
            buffer.putFloat(b)
        }

        buffer.rewind()
        return buffer
    }
}

