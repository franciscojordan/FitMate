package com.example.fitmate

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityLoadingScreenBinding
import com.example.fitmate.utils.NavigationUtils

class LoadingScreen : AppCompatActivity(){
    private lateinit var binding: ActivityLoadingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.max = 1000


        val animator = ValueAnimator.ofInt(0, 1000)
            .setDuration(2000)
        animator.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Int
            binding.progressBar.progress = progress

            // Verifica si el progreso ha llegado a 1000
            if (progress == 1000) {
                NavigationUtils.launchPreLogin(this, null)
                finish()
            }
        }
    animator.start()
    }
}