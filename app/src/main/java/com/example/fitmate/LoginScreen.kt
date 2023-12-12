package com.example.fitmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun launchRegister(view: View?) {
        val i = Intent(this, RegisterScreen::class.java)
        startActivity(i)
    }

    fun launchLogin(view: View?) {
        val i = Intent(this, LoginScreen::class.java)
        startActivity(i)
    }
}