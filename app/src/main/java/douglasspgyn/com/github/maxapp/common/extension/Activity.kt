package douglasspgyn.com.github.maxapp.common.extension

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import douglasspgyn.com.github.maxapp.R

fun Activity.snackbar(text: String, long: Boolean = false, dismissText: String? = null) {
    val view: View = findViewById(R.id.coordinator) ?: findViewById(android.R.id.content)

    showSnackbar(text, if (long) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT, view, dismissText)
}

private fun showSnackbar(text: String, length: Int, view: View, dismissText: String? = null) {
    Snackbar.make(view, text, length).setAction(dismissText) {}.show()
}