import android.content.Context
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.channels.FileChannel

class StyleTransfer(private val context: Context) {

    private val interpreter: Interpreter

    init {
        val fileDescriptor = context.assets.openFd("G_A2B.tflite")

        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val channel = inputStream.channel

        val model = channel.map(
            FileChannel.MapMode.READ_ONLY,
            fileDescriptor.startOffset,
            fileDescriptor.declaredLength
        )

        interpreter = Interpreter(model)
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
}

