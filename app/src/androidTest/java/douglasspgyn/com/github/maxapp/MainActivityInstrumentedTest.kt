package douglasspgyn.com.github.maxapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.ProgressBar
import douglasspgyn.com.github.maxapp.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun goToDataFragment() {
        onView(withId(R.id.clients)).perform(click())
        InstrumentedWaitResource.waitUntilViewNotNull<ProgressBar>(R.id.loading)
        onView(withId(R.id.loading)).check(matches(isDisplayed()))
    }
}