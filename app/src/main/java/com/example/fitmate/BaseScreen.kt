package com.example.fitmate;

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

abstract class BaseScreen : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        showExitConfirmationDialog()
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Confirmación de salida")
            .setMessage("¿Estás seguro de que quieres salir?")
            .setPositiveButton("Sí") { _, _ ->
                super.onBackPressed()
            }
            .setNegativeButton("No", null)
            .setCancelable(false)
            .show()
    }
}

