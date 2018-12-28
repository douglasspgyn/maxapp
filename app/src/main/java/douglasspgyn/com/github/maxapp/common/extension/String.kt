package douglasspgyn.com.github.maxapp.common.extension

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import douglasspgyn.com.github.maxapp.R

fun String.formSpanColor(colorChangePosition: Int): Spannable {
    val spannable: Spannable = SpannableString(this)
    spannable.setSpan(ForegroundColorSpan(Color.parseColor("#95989A")), 0, colorChangePosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannable.setSpan(ForegroundColorSpan(Color.parseColor("#000000")), colorChangePosition, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    return spannable
}

fun String.formValidateNotInformedField(context: Context): String = if (this.isEmpty()) context.getString(R.string.not_informed) else this