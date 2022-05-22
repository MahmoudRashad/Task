package com.rashad.app.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration


fun Context.startActivityAndClearStack(intent: Intent) {
  intent.addFlags(
    Intent.FLAG_ACTIVITY_CLEAR_TOP or
      Intent.FLAG_ACTIVITY_CLEAR_TASK or
      Intent.FLAG_ACTIVITY_NEW_TASK
  )
  startActivity(intent)
}

fun Activity.changeOrientationToLandscape(shouldLandscape: Boolean) {
  requestedOrientation = if (shouldLandscape) {
    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
  } else {
    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
  }
}

fun Activity.checkLandscapeOrientation() : Boolean {
  val orientation = resources.configuration.orientation
  return orientation == Configuration.ORIENTATION_LANDSCAPE
}
