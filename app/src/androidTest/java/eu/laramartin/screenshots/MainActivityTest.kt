package eu.laramartin.screenshots

import android.os.SystemClock
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    companion object {

        @get:ClassRule
        @JvmStatic
        val localeTestRule = LocaleTestRule()

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun displayHello() {
        SystemClock.sleep(1000)
        Screengrab.screenshot("01_initial_screen")
        onView(withId(R.id.button)).perform(click())
        SystemClock.sleep(1000)
        Screengrab.screenshot("02_displayed_text_screen")
        onView(withId(R.id.container)).check(matches(isDisplayed()))
    }
}
