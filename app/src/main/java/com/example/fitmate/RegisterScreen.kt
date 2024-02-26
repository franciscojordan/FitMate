package com.example.fitmate;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.databinding.ActivityRegisterBinding
import com.example.fitmate.utils.NavigationUtils
import com.example.fitmate.utils.ToolbarUtil

class RegisterScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.done.setOnClickListener{
            NavigationUtils.launchHome(this, null)
        }
    }

}
