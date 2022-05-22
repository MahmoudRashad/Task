package com.rashad.domain.authentication.common

import com.google.gson.JsonObject

data class MadrastyResponseModel(
    val Status: Int,
    val Code: Int,
    val Message: String,
    val Data: Any?,
    var Errors: List<JsonObject>? = null
)