package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityEjerciciosBinding

class EjerciciosScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEjerciciosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjerciciosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener{
            NavigationUtils.launchHome(this)
        }
    }
}