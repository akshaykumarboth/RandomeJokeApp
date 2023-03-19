package com.example.testttapplication.data.network

private const val UNKNOWN_ERROR = 520

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception?, val statusCode: Int? = UNKNOWN_ERROR) :
            ApiResult<Nothing>() {
        fun isUnknownError() = statusCode == UNKNOWN_ERROR
    }

    object NetworkError : ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is NetworkError -> "No Network Error"
        }
    }
}
