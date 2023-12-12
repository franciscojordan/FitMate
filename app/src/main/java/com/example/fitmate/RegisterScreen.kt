package com.example.fitmate;

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun launchLogin(view: View?) {
        val i = Intent(this, LoginScreen::class.java)
        startActivity(i)
    }
}
