package com.example.fitmate

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.LoadingScreenActivityBinding

class LoadingScreen : AppCompatActivity(){
    private lateinit var binding: LoadingScreenActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoadingScreenActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.max = 1000


        val animator = ValueAnimator.ofInt(0, 1000)
            .setDuration(2000)
        animator.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Int
            binding.progressBar.progress = progress

            // Verifica si el progreso ha llegado a 1000
            if (progress == 1000) {
                startActivity(Intent(this@LoadingScreen, LoginScreen::class.java))
                finish() // Cierra la actividad actual
            }
        }
    animator.start()
    }
}