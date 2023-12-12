package com.example.fitmate;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityRegisterBinding

class RegisterScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.swapLoginButton.setOnClickListener{
            NavigationUtils.launchLogin(this)
        }

        binding.done.setOnClickListener{
            NavigationUtils.launchHome(this)
        }
    }

}
