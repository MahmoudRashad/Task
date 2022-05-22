package com.rashad.app.di.modules

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.rashad.app.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides


@Module
class SessionModule {

  @Provides
  @ApplicationScope
  fun provideEncryptedSharedPreferences(
    application: Application,
    masterKey: MasterKey
  ): SharedPreferences =
    EncryptedSharedPreferences.create(
      application.baseContext,
      "Madrasty",
      masterKey,
      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
      EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

  @Provides
  @ApplicationScope
  fun provideMasterKey(
    application: Application,
  ): MasterKey = MasterKey.Builder(application.baseContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
    .build()
}