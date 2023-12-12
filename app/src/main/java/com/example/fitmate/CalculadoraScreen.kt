package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityCalculadoraBinding

class CalculadoraScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCalculadoraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.done.setOnClickListener{
            NavigationUtils.launchResultadoCalculadora(this)
        }

        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this)
        }

        binding.homeButton.setOnClickListener{
            NavigationUtils.launchHome(this)
        }

        binding.calculadoraButton.setOnClickListener{
            NavigationUtils.launchCalculator(this)
        }
    }
}