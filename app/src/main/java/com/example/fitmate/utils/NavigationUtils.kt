package com.example.fitmate.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitmate.CalculadoraScreen
import com.example.fitmate.EjerciciosScreen
import com.example.fitmate.HomeScreen
import com.example.fitmate.LoginScreen
import com.example.fitmate.PreLoginScreen
import com.example.fitmate.RecetasScreen
import com.example.fitmate.RegisterScreen
import com.example.fitmate.ScannedScreen
import com.example.fitmate.ScanningScreen

object NavigationUtils {

    fun start(b: Bundle? = null, c: Context, s: Class<*>){
        val i = Intent(c, s)
        if (b != null) {
            i.putExtras(b)
        }
        c.startActivity(i)
    }
    fun launchScanner(c: Context, b: Bundle? = null) {
        start(b, c, ScanningScreen::class.java)
    }

    fun launchCalculator(c: Context, b: Bundle? = null) {
        start(b, c, CalculadoraScreen::class.java)
    }

    fun launchEjercicios(c: Context, b: Bundle? = null) {
        start(b, c, EjerciciosScreen::class.java)
    }

    fun launchRecetas(c: Context, b: Bundle? = null) {
        start(b, c, RecetasScreen::class.java)
    }

    fun launchConfig(c: Context, b: Bundle? = null) {
        //start(b, c, ConfigScreen::class.java)
    }

    fun launchHome(c: Context, b: Bundle? = null) {
        start(b, c, HomeScreen::class.java)
    }

    fun launchLogin(c: Context, b: Bundle? = null) {
        start(b, c, LoginScreen::class.java)
    }

    fun launchRegister(c: Context, b: Bundle? = null) {
        start(b, c, RegisterScreen::class.java)
    }

    fun launchResultadoCalculadora (c: Context, b: Bundle? = null) {
        //start(b, c, ResultadoCalculadoraScreen::class.java)
    }

    fun launchScanned(c: Context, b: Bundle? = null) {
        start(b, c, ScannedScreen::class.java)
    }

    fun launchPreLogin(c: Context, b: Bundle? = null) {
        start(b, c, PreLoginScreen::class.java)
    }

    fun goBack(activity: AppCompatActivity) {
        activity.finish()
    }
}