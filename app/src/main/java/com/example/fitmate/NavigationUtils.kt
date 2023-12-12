package com.example.fitmate

import android.content.Context
import android.content.Intent

object NavigationUtils {
    fun launchScanner(context: Context) {
        val i = Intent(context, ScanningScreen::class.java)
        context.startActivity(i)
    }

    fun launchCalculator(context: Context) {
        val i = Intent(context, CalculadoraScreen::class.java)
        context.startActivity(i)
    }

    fun launchEjercicios(context: Context) {
        val i = Intent(context, EjerciciosScreen::class.java)
        context.startActivity(i)
    }

    fun launchRecetas(context: Context) {
        val i = Intent(context, RecetasScreen::class.java)
        context.startActivity(i)
    }

    fun launchConfig(context: Context) {
        //val i = Intent(context, ConfigScreen::class.java)
        //context.startActivity(i)
    }

    fun launchHome(context: Context) {
        val i = Intent(context, HomeScreen::class.java)
        context.startActivity(i)
    }

    fun launchLogin(context: Context) {
        val i = Intent(context, LoginScreen::class.java)
        context.startActivity(i)
    }

    fun launchRegister(context: Context) {
        val i = Intent(context, RegisterScreen::class.java)
        context.startActivity(i)
    }

    fun launchResultadoCalculadora (context: Context) {
        //val i = Intent(context, ResultadoCalculadoraScreen::class.java)
        //context.startActivity(i)
    }

    fun launchScanned(context: Context) {
        val i = Intent(context, ScannedScreen::class.java)
        context.startActivity(i)
    }
}