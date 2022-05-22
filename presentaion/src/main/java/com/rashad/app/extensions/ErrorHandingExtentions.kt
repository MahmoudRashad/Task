package com.rashad.app.extensions

import com.rashad.app.authentication.common.Resource
import org.json.JSONObject
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun <T> Throwable.toResource(
    otherError: (message: String) -> Resource<T> = { Resource.unknownError(it) }
): Resource<T> {

    this.printStackTrace()
    return when (this) {
        is HttpException -> map(this.code(), this.response()?.errorBody()!!.string())
        is UnknownHostException -> Resource.connectionError()
        is SocketTimeoutException -> Resource.connectionError()
        else -> otherError(this.message.toString())
    }
}

private fun <T> map(code: Int, errorBody: String): Resource<T> {
    val jsonObject = JSONObject(errorBody)
    val message = jsonObject.getString("Message")

    return when (code) {
        500 -> {
            Resource.serverError()
        }
        403 -> {
            Resource.forbiddenError(message)
        }
        404 -> {
            Resource.notFoundError(message)
        }
        400 -> {
            val errors = jsonObject.getJSONArray("Errors")
            Resource.badRequest(errors = errors)
        }
        401 -> {
            val dataObject = if (jsonObject.has("Data")){
                     jsonObject.getJSONObject("Data")
                } else {
                null
            }
            val errors = jsonObject.getJSONArray("Errors")
            val statusCode = jsonObject.getInt("Code")
            val msg = jsonObject.getString("Message")
            Resource.loginErrors(dataObject, errors, statusCode, msg)
        }
        else -> {
            Resource.unknownError()
        }
    }
}