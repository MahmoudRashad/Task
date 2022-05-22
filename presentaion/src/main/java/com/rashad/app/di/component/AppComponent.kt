package com.rashad.app.di.component

import android.app.Application
import com.rashad.app.di.activity.ActivitySubComponent
import com.rashad.app.di.modules.SessionModule
import com.rashad.app.di.retrofit.services.ServicesModule
import com.rashad.app.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ServicesModule::class,
        SessionModule::class
    ]
)
interface AppComponent {

    fun getActivitySubComponent(): ActivitySubComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}