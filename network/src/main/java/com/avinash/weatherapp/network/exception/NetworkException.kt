package com.avinash.weatherapp.network.exception

import java.lang.Exception

class NetworkException(errorCode: Int?, errorMessage: String) : Exception() {

    private var mErrorCode: Int? = errorCode
    private var mErrorMessage: String = errorMessage

    fun getErrorCode(): Int? {
        return mErrorCode
    }

    fun getErrorMessage(): String {
        return mErrorMessage
    }

}