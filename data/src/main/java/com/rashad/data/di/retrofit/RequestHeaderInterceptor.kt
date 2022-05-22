package com.rashad.data.di.retrofit

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject


class RequestHeaderInterceptor @Inject constructor(
  private val sharedPreferences: SharedPreferences
) : Interceptor {
  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()

    val newRequest = request.newBuilder()
      .addHeader("Accept-Language", "en")
      .addHeader("Version", "1.1")
      .addHeader("Authorization", authorizationHeaderValue(
        sharedPreferences.getString("access_token_key", "")!!))
      .build()

    return chain.proceed(newRequest)
  }

  private fun authorizationHeaderValue(token: String): String = "Bearer $token"
}