package douglasspgyn.com.github.maxapp

import android.app.Activity
import android.support.test.espresso.IdlingPolicies
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.IdlingResource
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import android.view.View
import java.util.concurrent.TimeUnit

object InstrumentedWaitResource {

    private const val defaultTimeout: Long = 16
    private val defaultTimeUnit: TimeUnit = TimeUnit.SECONDS

    fun waitViewVisibilityChange(
            view: View,
            visibility: Int,
            timeout: Long = defaultTimeout,
            unit: TimeUnit = defaultTimeUnit
    ) {
        IdlingPolicies.setIdlingResourceTimeout(timeout, unit)
        IdlingRegistry.getInstance().register(ViewVisibilityIdlingResource(view, visibility))
    }

    fun <T : View> waitUntilViewNotNull(viewId: Int, timeout: Long = defaultTimeout, unit: TimeUnit = defaultTimeUnit) {
        IdlingPolicies.setIdlingResourceTimeout(timeout, unit)
        IdlingRegistry.getInstance().register(ViewNotNullIdlingResource<T>(viewId))
    }

    private class ViewVisibilityIdlingResource(val view: View, val expectedVisibility: Int) : IdlingResource {

        private var mIdle: Boolean = false
        private var mResourceCallback: IdlingResource.ResourceCallback? = null

        override fun getName(): String {
            return ViewVisibilityIdlingResource::class.java.simpleName
        }

        override fun isIdleNow(): Boolean {
            mIdle = view.visibility == expectedVisibility

            if (mIdle && mResourceCallback != null) {
                mResourceCallback!!.onTransitionToIdle()
            }

            return mIdle
        }

        override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
            mResourceCallback = resourceCallback
        }
    }

    private class ViewNotNullIdlingResource<T : View>(val viewId: Int) : IdlingResource {

        private var mIdle: Boolean = false
        private var mResourceCallback: IdlingResource.ResourceCallback? = null

        override fun getName(): String {
            return ViewNotNullIdlingResource::class.java.simpleName
        }

        override fun isIdleNow(): Boolean {
            mIdle = currentActivity().findViewById<T>(viewId) != null

            if (mIdle && mResourceCallback != null) {
                mResourceCallback!!.onTransitionToIdle()
            }

            return mIdle
        }

        override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
            mResourceCallback = resourceCallback
        }
    }

    private fun currentActivity(): Activity {
        return (ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED) as MutableList)[0]
    }
}