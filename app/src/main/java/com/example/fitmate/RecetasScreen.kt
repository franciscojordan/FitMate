package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityRecetasBinding

class RecetasScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRecetasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecetasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.backButton.setOnClickListener{
            NavigationUtils.launchHome(this)
        }
    }
}