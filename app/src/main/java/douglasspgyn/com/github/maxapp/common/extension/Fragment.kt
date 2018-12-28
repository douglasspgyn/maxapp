package douglasspgyn.com.github.maxapp.common.extension

import android.support.v4.app.Fragment

fun Fragment.snackbar(text: String, long: Boolean = false, dismissText: String? = null) {
    activity?.snackbar(text, long, dismissText)
}