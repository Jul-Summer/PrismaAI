package com.example.prismaapp

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class TFLiteModel(context: Context, modelName: String) {

    private val interpreter: Interpreter

    init {
        interpreter = Interpreter(loadModelFile(context, modelName))
    }

    private fun loadModelFile(context: Context, modelName: String): MappedByteBuffer {
        val fileDescriptor = context.assets.openFd(modelName)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        return fileChannel.map(
            FileChannel.MapMode.READ_ONLY,
            fileDescriptor.startOffset,
            fileDescriptor.declaredLength
        )
    }

    fun run(
        input: Array<Array<Array<FloatArray>>>
    ): Array<Array<Array<FloatArray>>> {

        val output = Array(1) {
            Array(256) {
                Array(256) {
                    FloatArray(3)
                }
            }
        }

        interpreter.run(input, output)

        return output
    }

    fun close() {
        interpreter.close()
    }
}