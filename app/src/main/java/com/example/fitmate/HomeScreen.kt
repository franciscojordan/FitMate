package com.example.fitmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmate.databinding.ActivityHomeScreenBinding
import com.example.fitmate.utils.NavigationUtils


class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera el valor del intent
        val isGuest = intent.getBooleanExtra("IS_GUEST", true)

        if (isGuest) {
            setGuestUserValues()
        } else {
            setLoggedUserValues()
        }

        binding.calcButton.setOnClickListener{
            NavigationUtils.launchCalculator(this, null)
        }

        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this)
        }

        binding.moreEjerciciosButton.setOnClickListener{
            NavigationUtils.launchEjercicios(this)
        }

        binding.moreRecetasButton.setOnClickListener{
            NavigationUtils.launchRecetas(this)
        }

        binding.configButton.setOnClickListener{
            NavigationUtils.launchConfig(this)
        }
    }
    private fun setGuestUserValues() {
        val context = applicationContext
        binding.username.text = context.getString(R.string.usernameInvitado)
        binding.email.text = context.getString(R.string.emailInvitado)
    }

    private fun setLoggedUserValues() {
        val context = applicationContext
        binding.username.text = context.getString(R.string.username)
        binding.email.text = context.getString(R.string.email)
    }
}