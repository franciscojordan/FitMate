package com.example.fitmate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fitmate.databinding.ActivityCalculadoraBinding
import com.example.fitmate.utils.NavigationUtils

class CalculadoraScreen : BaseScreen() {
    private lateinit var binding: ActivityCalculadoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón de información
        val infoButton: ImageButton = findViewById(R.id.info_button)
        infoButton.setOnClickListener {
            showInfoPopup()
        }

        binding.done.setOnClickListener{
            NavigationUtils.launchResultadoCalculadora(this, null)
        }

        binding.scannerButton.setOnClickListener{
            NavigationUtils.launchScanner(this, null)
        }

        binding.homeButton.setOnClickListener{
            NavigationUtils.launchHome(this, null)
        }

        binding.calculadoraButton.setOnClickListener{
            NavigationUtils.launchCalculator(this, null)
        }
    }

    private fun showInfoPopup() {
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.popup_info, null)

        val popupWindow = PopupWindow(
            popupView,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        // Cerrar el popup cuando se presiona el botón de cerrar
        val closeButton: ImageButton = popupView.findViewById(R.id.close_button)
        closeButton.setOnClickListener {
            popupWindow.dismiss()
        }

        // Mostrar el popup
        popupWindow.showAtLocation(binding.root, android.view.Gravity.CENTER, 0, 0)
    }
}
