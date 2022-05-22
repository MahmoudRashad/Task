package com.rashad.app.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.rashad.app.ui.activities.AuthActivity

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(rootView?.windowToken, 0)
}

val ViewGroup.layoutInflater: LayoutInflater get() = LayoutInflater.from(this.context)

@SuppressLint("NewApi")
fun String.reFormateDate(): String {
    val parsedDate = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
    return parsedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
}

fun Context.shareToSocialMedia(shareText: String) {
    val intent = Intent()
    intent.action = Intent.ACTION_SEND
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, shareText)
    startActivity(Intent.createChooser(intent, "Share"))
}

fun String.showHtmlText(): Spanned? {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        return Html.fromHtml(this)
    }
}

fun Activity.showProgressWheel(show: Boolean) {
    if (show) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    when (this) {
        is AuthActivity -> binding.authProgress.isVisible = show
    }
}