package com.rashad.app.di.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rashad.app.di.scope.PerActivity
import com.rashad.app.ui.splash.viewmodels.SplashViewModel
import com.rashad.app.di.ViewModelFactory
import com.rashad.app.di.annotaions.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ActivityViewModelModule {

  @Binds
  internal  abstract fun bindViewModelFactory(factory: ViewModelFactory):
          ViewModelProvider.Factory

  @Binds
  @IntoMap
  @PerActivity
  @ViewModelKey(SplashViewModel::class)
  abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel



}