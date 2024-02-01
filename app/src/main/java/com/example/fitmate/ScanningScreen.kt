package com.example.fitmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityScanningBinding
import com.example.fitmate.utils.NavigationUtils


class ScanningScreen : AppCompatActivity() {
    private lateinit var binding: ActivityScanningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dropScannedButton.setOnClickListener{
            NavigationUtils.launchScanned(this, null)
        }
        binding.calculadoraButton.setOnClickListener{
            NavigationUtils.launchCalculator(this, null)
        }
        binding.homeButton.setOnClickListener{
            NavigationUtils.launchHome(this, null)
        }
        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this, null)
        }
    }
}