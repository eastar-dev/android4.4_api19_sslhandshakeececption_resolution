package dev.eastar.sslhandshakeececption

import android.log.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.security.ProviderInstaller
import dev.eastar.sslhandshakeececption.databinding.ActivityMainBinding


class MainInstallIfNeeded : AppCompatActivity() {
    private lateinit var bb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProviderInstaller.installIfNeeded(this)
        Log.toast(this, "onProviderInstalled")
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)
        bb.button.setOnClickListener { run(this) }
    }
}
