package com.example.fitmate

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.database.DatabaseAPP
import com.example.fitmate.databinding.ActivityLoginBinding
import com.example.fitmate.utils.NavigationUtils

class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseAPP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseAPP.getInstance(this)

        binding.done.setOnClickListener {
            val username = binding.usernameText.text.toString()
            val password = binding.passwordText.text.toString()

            if (databaseHelper.verifyUser(username, password)) {
                // Credenciales correctas, proceder con el login
                val bundle = Bundle()
                bundle.putString("USERNAME", username)
                bundle.putBoolean("IS_GUEST", false)// Pase el nombre de usuario o cualquier otro dato relevante
                NavigationUtils.launchHome(this, bundle)
            } else {
                // Credenciales incorrectas, mostrar mensaje de error y resaltar el campo de contraseña
                binding.password.error = "Contraseña incorrecta"
                binding.password.isErrorEnabled = true
            }
        }

        binding.guestLogin.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("IS_GUEST", true)
            NavigationUtils.launchHome(this, bundle)
        }
    }
}
