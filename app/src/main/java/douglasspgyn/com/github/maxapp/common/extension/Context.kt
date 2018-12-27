package douglasspgyn.com.github.maxapp.common.extension

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return connectivityManager?.let {
        val netInfo = it.activeNetworkInfo
        netInfo?.let {
            it.isConnected
        } ?: false
    } ?: false
}