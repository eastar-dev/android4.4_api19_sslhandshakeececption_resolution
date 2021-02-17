package dev.eastar.sslhandshakeececption

import android.log.Log
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.sslhandshakeececption.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException
import java.util.*

class ConnectSample : AppCompatActivity() {
    private lateinit var bb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.button.setOnClickListener { run(this) }

    }

}


private val client = OkHttpClient()

fun run(context: AppCompatActivity) {
    val request = Request.Builder()
        .url("https://moffice-dev.hanabank.com:8080/")
        .build()

    client.newCall(request)
        .enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.printStackTrace(e)
                context.runOnUiThread {
                    Log.toast(context, Arrays.toString(e.stackTrace))
                    AlertDialog.Builder(context).setMessage(Arrays.toString(e.stackTrace)).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.headers().toMultimap().entries.forEach {
                    context.runOnUiThread {
                        Log.toast(context, "${it.key} : ${it.value}")

                    }

                }
                context.runOnUiThread {
                    Log.toast(context, response.body()?.string())
                }
            }

        })
}