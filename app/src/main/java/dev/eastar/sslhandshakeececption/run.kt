package dev.eastar.sslhandshakeececption

import android.log.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException
import java.util.*


fun run(context: AppCompatActivity) {
    val request = Request.Builder()
        .url("https://moffice-dev.hanabank.com:8080/")
        .build()

    val client = OkHttpClient()
    client.newCall(request)
        .enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.printStackTrace(e)
                context.runOnUiThread {
                    //Log.toast(context, Arrays.toString(e.stackTrace))
                    AlertDialog.Builder(context)
                        .setMessage(Arrays.toString(e.stackTrace))
                        .setPositiveButton("ok") { _, _ -> }
                        .show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                context.runOnUiThread {
                    //Log.toast(context, response.body()?.string())
                    context.runOnUiThread {
                        AlertDialog.Builder(context)
                            .setMessage(response.body()?.string())
                            .setPositiveButton("ok") { _, _ -> }
                            .show()
                    }
                }
            }
        })
}