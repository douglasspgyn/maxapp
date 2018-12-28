package douglasspgyn.com.github.maxapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import douglasspgyn.com.github.maxapp.ui.client.ClientActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataFragmentInstrumentedTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(ClientActivity::class.java)

    @Test
    fun loadClientData() {
        InstrumentedWaitResource.waitViewVisibilityChange(activityTestRule.activity.findViewById(R.id.loading), View.GONE)
        InstrumentedWaitResource.waitViewVisibilityChange(activityTestRule.activity.findViewById(R.id.clientContainer), View.VISIBLE)
        onView(withId(R.id.clientContainer)).check(matches(isDisplayed()))
    }

    @Test
    fun loadOrderHistory() {
        onView(withId(R.id.menuOrderHistory)).perform(click())
        InstrumentedWaitResource.waitViewVisibilityChange(activityTestRule.activity.findViewById(R.id.loading), View.GONE)
        InstrumentedWaitResource.waitViewVisibilityChange(activityTestRule.activity.findViewById(R.id.recyclerView), View.VISIBLE)
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}