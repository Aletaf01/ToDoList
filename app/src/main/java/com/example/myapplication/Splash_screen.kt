package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.model.LoggedInUser
import com.example.myapplication.ui.login.LoginActivity
import com.example.myapplication.ui.theme.MyApplicationTheme

class Splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,LoginActivity::class.java).apply {})
            finish() // Fix che fa comparire la splash screen solo all'avvio
        }, 2000)
    }
}