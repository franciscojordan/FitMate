package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityCalculadoraBinding
import com.example.fitmate.utils.NavigationUtils

class CalculadoraScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.done.setOnClickListener{
            NavigationUtils.launchResultadoCalculadora(this, null)
        }

        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this, null)
        }

        binding.homeButton.setOnClickListener{
            NavigationUtils.launchHome(this, null)
        }

        binding.calculadoraButton.setOnClickListener{
            NavigationUtils.launchCalculator(this, null)
        }
    }
}