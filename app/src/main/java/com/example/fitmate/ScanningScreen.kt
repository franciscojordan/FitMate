package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityScanningBinding


class ScanningScreen : AppCompatActivity() {
    private lateinit var binding: ActivityScanningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanningBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dropScannedButton.setOnClickListener{
            NavigationUtils.launchScanned(this)
        }
        binding.calculadoraButton.setOnClickListener{
            NavigationUtils.launchCalculator(this)
        }
        binding.homeButton.setOnClickListener{
            NavigationUtils.launchHome(this)
        }
        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this)
        }
    }
}