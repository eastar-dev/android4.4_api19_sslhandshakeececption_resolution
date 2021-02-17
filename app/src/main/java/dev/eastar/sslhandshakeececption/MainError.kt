package dev.eastar.sslhandshakeececption

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.sslhandshakeececption.databinding.ActivityMainBinding

class MainError : AppCompatActivity() {
    private lateinit var bb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.button.setOnClickListener { run(this) }
    }
}


