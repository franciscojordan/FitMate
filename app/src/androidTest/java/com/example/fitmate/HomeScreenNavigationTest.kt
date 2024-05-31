package com.example.fitmate

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitmate.R
import com.example.fitmate.utils.NavigationUtils
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenNavigationTest {

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testScannerButtonNavigatesToScannerScreen() {
        ActivityScenario.launch(HomeScreen::class.java)

        onView(withId(R.id.scannerButton)).perform(click())

        Intents.intended(hasComponent(ScanningScreen::class.java.name))
    }

    @Test
    fun testHomeButtonNavigatesToHomeScreen() {
        ActivityScenario.launch(HomeScreen::class.java)

        onView(withId(R.id.homeButton)).perform(click())

        Intents.intended(hasComponent(HomeScreen::class.java.name))
    }

    @Test
    fun testCalculadoraButtonNavigatesToCalculatorScreen() {
        ActivityScenario.launch(HomeScreen::class.java)

        onView(withId(R.id.calcButton)).perform(click())

        Intents.intended(hasComponent(CalculadoraScreen::class.java.name))
    }
}
