package com.example.fitmate.utils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

object ToolbarUtil {
    fun setupToolbar(activity: AppCompatActivity, toolbarId: Int) {
        val toolbar: Toolbar? = activity.findViewById(toolbarId)
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayShowTitleEnabled(false)

        // Aquí puedes agregar más configuración de la Toolbar si es necesario
    }
}
