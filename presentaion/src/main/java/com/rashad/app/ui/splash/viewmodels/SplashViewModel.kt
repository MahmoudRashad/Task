package com.rashad.app.ui.splash.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.rashad.app.base.BaseViewModel
import com.rashad.app.extensions.defaultValue
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel()  {


    //waiting time before start
    private val delayTime : Long = 1000

    val ready = MutableLiveData<Boolean>()

    init {
        Handler(Looper.getMainLooper()).postDelayed({
            // do any init steps
            // or check version
            // set ready  ture to  start or false to hold on splash
            ready.defaultValue(true)
        }, delayTime)
    }
}