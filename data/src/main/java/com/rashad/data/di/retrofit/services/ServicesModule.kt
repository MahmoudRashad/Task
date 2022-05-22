package com.rashad.data.di.retrofit.services

import com.rashad.data.di.retrofit.RetrofitModule
import com.rashad.data.di.scope.ApplicationScope
import com.rashad.data.features.auth.AuthApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module(
  includes = [
    RetrofitModule::class
  ]
)

class ServicesModule {

  @Provides
  @ApplicationScope
  fun provideAuthServices(
    retrofit: Retrofit
  ): AuthApiService {
    return retrofit.create(AuthApiService::class.java)
  }


}