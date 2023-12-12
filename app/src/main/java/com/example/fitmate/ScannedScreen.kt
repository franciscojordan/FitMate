package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityScannedBinding

class ScannedScreen : AppCompatActivity() {
    private lateinit var binding: ActivityScannedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener{
            NavigationUtils.launchScanner(this)
        }
    }
}