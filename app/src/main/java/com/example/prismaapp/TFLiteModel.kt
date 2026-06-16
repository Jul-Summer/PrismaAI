package com.example.prismaapp

import org.tensorflow.lite.Interpreter
import java.nio.ByteBuffer
import java.nio.ByteOrder

class TFLiteModel(
    private val interpreter: Interpreter
) {

    fun run(input: ByteBuffer): ByteBuffer {

        val output = ByteBuffer.allocateDirect(1 * 256 * 256 * 3 * 4)
        output.order(ByteOrder.nativeOrder())

        interpreter.run(input, output)

        output.rewind()
        return output
    }
}