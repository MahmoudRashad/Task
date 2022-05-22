package com.rashad.app.utils.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import com.rashad.app.TaskAPP
import com.rashad.app.ui.activities.AuthActivity
import com.rashad.app.di.activity.ActivitySubComponent
import com.rashad.app.di.component.AppComponent


/**
 * enable dagger AppComponent for any Activity
 */
val Activity.appComponent: AppComponent get() = (application as TaskAPP).appComponent

/**
 * enable dagger AppComponent for any Fragment
 */
val Fragment.appComponent: AppComponent get() =
    (context?.applicationContext as TaskAPP).appComponent

/**
 * enable dagger MainActivityComponent for any Fragment
 * @author Rashad
 */
val Fragment.authActivityComponent: ActivitySubComponent
    get() = (activity as AuthActivity).activitySubComponent

