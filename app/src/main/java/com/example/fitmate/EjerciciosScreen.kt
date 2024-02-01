package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityEjerciciosBinding
import com.example.fitmate.utils.NavigationUtils

class EjerciciosScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEjerciciosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            NavigationUtils.goBack(this)
        }
    }
}