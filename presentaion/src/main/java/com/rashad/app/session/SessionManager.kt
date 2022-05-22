package com.rashad.app.session

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rashad.app.extensions.get
import com.rashad.app.extensions.put
import com.rashad.app.extensions.remove
import javax.inject.Inject


class SessionManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token_key"
        private const val REFRESH_TOKEN_KEY = "refresh_token_key"
        private const val CURRENT_USER_KEY = "current_user_key"
        private const val REMEMBER_ME_KEY = "rememberMeKey"
        private const val USER_EMAIL_KEY = "user_email_key"
        private const val USER_PASS_KEY = "user_pass_key"
        private const val IS_FIRST_LOGIN = "isFirstLogin"
    }

    fun getSavedAccessToken(): String? = sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
    private fun removeAccessToken() = sharedPreferences.remove(ACCESS_TOKEN_KEY)
    fun saveAccessToken(accessToken: String) = sharedPreferences.put(ACCESS_TOKEN_KEY, accessToken)



    private fun removeSavedCurrentUser() = sharedPreferences.remove(CURRENT_USER_KEY)

    fun setFirstLogin(firstTime: Boolean) = sharedPreferences.put(IS_FIRST_LOGIN, firstTime)
    fun isFirstLogin(): Boolean = sharedPreferences.get(IS_FIRST_LOGIN, true)

    fun setRememberMe(isRememberMe: Boolean) = sharedPreferences.put(REMEMBER_ME_KEY, isRememberMe)
    fun isRememberMe(): Boolean = sharedPreferences.get(REMEMBER_ME_KEY, false)

    private fun resetIsRememberMe() {
        sharedPreferences.put(REMEMBER_ME_KEY, false)
    }

    fun clearCredentials() {
        resetIsRememberMe()
    }

    @SuppressLint("CheckResult")
    fun logout() {
        clearUserData()
    }

    private fun clearUserData() {
        setRememberMe(false)
        removeAccessToken()
        removeSavedCurrentUser()
    }
}