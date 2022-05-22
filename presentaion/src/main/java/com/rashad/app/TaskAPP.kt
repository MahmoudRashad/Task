package com.rashad.app

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.rashad.app.di.component.AppComponent
import com.rashad.app.di.component.DaggerAppComponent
import timber.log.Timber

class TaskAPP : Application(){

    lateinit var appComponent: AppComponent

    companion object {
        fun get(activity: FragmentActivity): TaskAPP {
            return activity.application as TaskAPP
        }
    }

    private fun setupInjection() {
        appComponent = DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        setupInjection()
        Timber.plant(Timber.DebugTree())
    }

}