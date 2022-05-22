package com.rashad.app.di.activity

import com.rashad.app.di.scope.PerActivity
import com.rashad.app.features.auth.AuthenticationRepositoryImpl
import com.rashad.app.authentication.repositories.AuthenticationRepository
import dagger.Binds
import dagger.Module


@Module
abstract class ActivityModule {

  @Binds
  @PerActivity
  abstract fun bindAuthenticationRepository(
      authenticationRepository: AuthenticationRepositoryImpl
  ): AuthenticationRepository

}