package com.example.fitmate

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.database.DatabaseAPP
import com.example.fitmate.databinding.ActivityRegisterBinding
import com.example.fitmate.utils.NavigationUtils

class RegisterScreen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var databaseHelper: DatabaseAPP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = DatabaseAPP(this)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requirementLength = findViewById<TextView>(R.id.requirement_length)
        val requirementUppercase = findViewById<TextView>(R.id.requirement_uppercase)
        val requirementNumber = findViewById<TextView>(R.id.requirement_number)
        val requirementSpecial = findViewById<TextView>(R.id.requirement_special)

        binding.passwordText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatePassword(s.toString(), requirementLength, requirementUppercase, requirementNumber, requirementSpecial)
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.done.setOnClickListener {
            val username = binding.usernameText.text.toString()
            val password = binding.passwordText.text.toString()
            val email = binding.emailText.text.toString()

            if (isPasswordValid(password)) {
                databaseHelper.addUser(username, password, email)
                NavigationUtils.launchLogin(this, null)
            } else {
                Toast.makeText(this, "La contraseña no cumple con los requisitos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validatePassword(password: String, requirementLength: TextView, requirementUppercase: TextView, requirementNumber: TextView, requirementSpecial: TextView) {
        if (password.length >= 6) {
            requirementLength.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            requirementLength.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        if (password.any { it.isUpperCase() }) {
            requirementUppercase.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            requirementUppercase.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        if (password.any { it.isDigit() }) {
            requirementNumber.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            requirementNumber.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        if (password.any { "!@#$%^&*".contains(it) }) {
            requirementSpecial.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            requirementSpecial.setTextColor(resources.getColor(android.R.color.darker_gray))
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        val lengthValid = password.length >= 6
        val uppercaseValid = password.any { it.isUpperCase() }
        val numberValid = password.any { it.isDigit() }
        val specialCharValid = password.any { "!@#$%^&*".contains(it) }

        return lengthValid && uppercaseValid && numberValid && specialCharValid
    }
}
