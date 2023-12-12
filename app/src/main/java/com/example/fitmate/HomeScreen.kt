package com.example.fitmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmate.databinding.ActivityHomeScreenBinding



class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calcButton.setOnClickListener{
            NavigationUtils.launchCalculator(this)
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
}