package br.edu.ufabc.githubclassroomtutorial

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withText

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Type a random name in the EditText, click the button,
     * then checks if the TextView has the expected message.
     */
    @Test
    fun testMessageWithAName() {
        val name = listOf(
            "Jung-Hoon",
            "Seleucus",
            "Kyrylo",
            "Margarida",
            "Yanis"
        ).shuffled().first()
        val expected = "Hello, $name! Welcome to UFABC!"
        onView(withHint("Type your name"))
            .withFailureHandler(newHandler("Failed to find a EditText with the int 'Type your name'"))
            .check(matches(isDisplayed()))
            .withFailureHandler(newHandler("EditText to type a name is not being displayed"))
            .perform(typeText(name))
            .withFailureHandler(newHandler("Failed to type a text in the EditText"))
            .perform(closeSoftKeyboard())
            .withFailureHandler(newHandler("Failed to close soft keyboard"))

        onView(withText("Greet"))
            .withFailureHandler(newHandler("Failed to find a button with the text 'Greet'"))
            .check(matches(isDisplayed()))
            .withFailureHandler(newHandler("Greet button is not visible"))
            .perform(click())
            .withFailureHandler(newHandler("Failed to click on the greet button"))

        onView(withText(expected))
            .withFailureHandler(newHandler("Failed to find TextView with expected message '$expected'"))
            .check(matches(isDisplayed()))
            .withFailureHandler(newHandler("TextView with expected message is not displayed"))
    }
}
