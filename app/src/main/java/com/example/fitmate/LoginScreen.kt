package com.example.fitmate;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityLoginBinding
import com.example.fitmate.utils.NavigationUtils

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.done.setOnClickListener {
            val bundle = Bundle()
                bundle.putBoolean("IS_GUEST", false)
            NavigationUtils.launchHome(this, bundle)
        }
        binding.guestLogin.setOnClickListener {
            val bundle = Bundle()
                bundle.putBoolean("IS_GUEST", true)
            NavigationUtils.launchHome(this, bundle)
        }

    }
}
