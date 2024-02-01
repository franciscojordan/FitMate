package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityPreLoginBinding
import com.example.fitmate.utils.NavigationUtils

class PreLoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityPreLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            NavigationUtils.launchLogin(this, null)
        }
        binding.register.setOnClickListener {
            NavigationUtils.launchRegister(this, null)
        }

    }
}