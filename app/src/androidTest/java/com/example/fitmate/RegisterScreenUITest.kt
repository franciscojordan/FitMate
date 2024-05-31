package com.example.fitmate

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterScreenUITest {

    @get:Rule
    val activityRule = ActivityTestRule(RegisterScreen::class.java)

    @Test
    fun testTextFieldsAreDisplayed() {
        // iniciar registre
        ActivityScenario.launch(RegisterScreen::class.java)

        // verifica nom d'usuari es mostra
        onView(withId(R.id.usernameText)).check(matches(isDisplayed()))

        // verifica contrasenya es mostra
        onView(withId(R.id.passwordText)).check(matches(isDisplayed()))

        // verifica correu electrònic es mostra
        onView(withId(R.id.emailText)).check(matches(isDisplayed()))

        // Verifica requeriments de la contrasenya es mostren
        onView(withId(R.id.requirement_length)).check(matches(isDisplayed()))
        onView(withId(R.id.requirement_uppercase)).check(matches(isDisplayed()))
        onView(withId(R.id.requirement_number)).check(matches(isDisplayed()))
        onView(withId(R.id.requirement_special)).check(matches(isDisplayed()))
    }
}
