package com.example.fitmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitmate.adapter.ExerciseAdapter
import com.example.fitmate.database.DatabaseAPP
import com.example.fitmate.databinding.ActivityHomeScreenBinding
import com.example.fitmate.utils.NavigationUtils


class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera el valor del intent
        val isGuest = intent.getBooleanExtra("IS_GUEST", true)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerEjercicios)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val exerciseData = DatabaseAPP.getInstance(this).generateSampleData()
        recyclerView.adapter = ExerciseAdapter(exerciseData)

        if (isGuest) {
            setGuestUserValues()
        } else {
            setLoggedUserValues()
        }

        binding.calcButton.setOnClickListener{
            NavigationUtils.launchCalculator(this, null)
        }

        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this)
        }

        binding.configButton.setOnClickListener{
            NavigationUtils.launchSettings(this)
        }

        binding.moreEjerciciosButton.setOnClickListener{
            NavigationUtils.launchEjercicios(this)
        }

        binding.moreRecetasButton.setOnClickListener{
            NavigationUtils.launchRecetas(this)
        }

        binding.configButton.setOnClickListener{
            NavigationUtils.launchConfig(this)
        }
    }
    private fun setGuestUserValues() {
        val context = applicationContext
        binding.username.text = context.getString(R.string.usernameInvitado)
        binding.email.text = context.getString(R.string.emailInvitado)
    }

    private fun setLoggedUserValues() {
        // Obtener el nombre de usuario y el email del Intent
        val username = intent.getStringExtra("USERNAME")

        if (username != null) {
            val databaseHelper = DatabaseAPP(this)
            val email = databaseHelper.getUserEmailByUsername(username)
            binding.username.text = username
            binding.email.text = email ?: "Email no encontrado"
        }
    }
}