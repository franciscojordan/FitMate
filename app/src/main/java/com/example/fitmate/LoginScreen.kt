package com.example.fitmate;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityLoginBinding

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.swapRegisterButton.setOnClickListener{
            NavigationUtils.launchRegister(this)
        }
        binding.done.setOnClickListener{
            NavigationUtils.launchHome(this)
        }
    }

}
