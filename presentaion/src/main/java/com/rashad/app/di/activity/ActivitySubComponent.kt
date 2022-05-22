package com.rashad.app.di.activity

import android.app.Activity
import com.rashad.app.ui.activities.AuthActivity
import com.rashad.app.ui.splash.fragments.TaskFragment
import com.rashad.data.di.scope.PerActivity
import dagger.BindsInstance
import dagger.Subcomponent


@PerActivity
@Subcomponent(modules = [ActivityModule::class, ActivityViewModelModule::class])
interface ActivitySubComponent {

  fun inject(authActivity: AuthActivity)



  fun inject( splashFragment: TaskFragment)
  fun inject( taskFragment: TaskFragment)




  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance activity: Activity): ActivitySubComponent
  }
}