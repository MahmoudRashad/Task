package com.rashad.domain.authentication.common

import androidx.annotation.Keep
import com.rashad.domain.authentication.common.ResourceType.*
import org.json.JSONArray
import org.json.JSONObject

@Keep
class Resource<T> {
    val resourceType: ResourceType
    var data: T? = null
    var dataError: JSONObject? = null
    var message: String? = null
        private set
    var statusCode: Int? = null
        private set
    var errors: JSONArray? = null
        private set

    constructor(
        resourceType: ResourceType,
        data: T?,
        message: String?
    ) {
        this.resourceType = resourceType
        this.data = data
        this.message = message
    }

    constructor(
        resourceType: ResourceType,
        data: T?
    ) {
        this.resourceType = resourceType
        this.data = data
    }

    constructor(
        resourceType: ResourceType,
        statusCode: Int,
        errors: JSONArray,
        message: String?,
        data: T?
    ) {
        this.resourceType = resourceType
        this.data = data
        this.statusCode = statusCode
        this.errors = errors
        this.message = message
    }

    constructor(
        resourceType: ResourceType,
        message: String?
    ) {
        this.resourceType = resourceType
        this.message = message
    }

    constructor(
        resourceType: ResourceType,
        data: T?,
        errors: JSONArray
    ) {
        this.resourceType = resourceType
        this.data = data
        this.errors = errors
    }

    constructor(
        resourceType: ResourceType,
        errors: JSONArray
    ) {
        this.resourceType = resourceType
        this.errors = errors
    }

    constructor(
        resourceType: ResourceType,
        data: JSONObject?,
        errors: JSONArray,
        code: Int,
        message: String?
    ) {
        this.resourceType = resourceType
        this.dataError = data
        this.errors = errors
        this.statusCode = code
        this.message = message
    }

    constructor(
        resourceType: ResourceType,
        statusCode: Int,
        message: String? = null
    ) {
        this.resourceType = resourceType
        this.statusCode = statusCode
        this.message = message
    }

    constructor(
        resourceType: ResourceType,
    ) {
        this.resourceType = resourceType
    }

    companion object {
        const val SUCCESS_API = 200

        fun <T> loading(): Resource<T> = Resource(LOADING, data = null)

        fun <T> loading(data: T): Resource<T> = Resource(LOADING, data)

        fun <T> error(data: T): Resource<T> = Resource(ERROR, data)

        fun <T> errorWithData(data: T?, errors: JSONArray): Resource<T> =
            Resource(ERROR, data, errors)

        fun <T> success(): Resource<T> = Resource(SUCCESS, data = null)

        fun <T> success(data: T): Resource<T> = Resource(SUCCESS, data)

        fun <T> success(
            data: T,
            message: String?
        ): Resource<T> =
            Resource(SUCCESS, data, message)

        fun <T> successMessage(message: String?): Resource<T> =
            Resource(SUCCESS, message)

        fun <T> connectionError(): Resource<T> =
            Resource(ResourceType.CONNECTION_ERROR)

        fun <T> error(errors: JSONArray): Resource<T> =
            Resource(ERROR, errors)

        fun <T> validationError(
            statusCode: Int,
            message: String? = null
        ): Resource<T> =
            Resource(ResourceType.VALIDATION_ERROR, statusCode, message)

        fun <T> unknownError(
            message: String? = null
        ): Resource<T> =
            Resource(ResourceType.UNKNOWN_ERROR, message)

        fun <T> forbiddenError(message: String): Resource<T> =
            Resource(ResourceType.FORBIDDEN_ERROR, message = message)

        fun <T> notFoundError(message: String?): Resource<T> =
            Resource(ResourceType.NOT_FOUND, message = message)

        fun <T> badRequest(errors: JSONArray): Resource<T> =
            Resource(ResourceType.BAD_REQUEST, errors = errors)

        fun <T> loginErrors(data: JSONObject?,
                            errors: JSONArray,
                            code: Int,
        message: String?): Resource<T> =
            Resource(LOGIN_ERRORS, data, errors = errors, code, message)

        fun <T> notAuthorize(message: String?): Resource<T> =
            Resource(ResourceType.NOT_AUTHORIZE, message = message)

        fun <T> serverError(): Resource<T> =
            Resource(ResourceType.SERVER_ERROR)

    }
}