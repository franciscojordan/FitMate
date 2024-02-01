package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityScannedBinding
import com.example.fitmate.utils.NavigationUtils

class ScannedScreen : AppCompatActivity() {
    private lateinit var binding: ActivityScannedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            NavigationUtils.goBack(this)
        }
    }
}