package com.example.fitmate;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityHomeScreenBinding
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
        binding.done.setOnClickListener {
            val isGuest = false
            val intent = Intent(this, HomeScreen::class.java)
            intent.putExtra("IS_GUEST", isGuest)
            startActivity(intent)
        }
        binding.guestLogin.setOnClickListener {
            val isGuest = true
            val intent = Intent(this, HomeScreen::class.java)
            intent.putExtra("IS_GUEST", isGuest)
            startActivity(intent)
        }

    }
}
