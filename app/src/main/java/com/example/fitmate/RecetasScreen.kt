package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityRecetasBinding
import com.example.fitmate.utils.NavigationUtils

class RecetasScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRecetasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            NavigationUtils.goBack(this)
        }
    }
}