package com.neal786y.mvparchitecture.base

interface ResponseCallback<T> {

    fun onSuccess(response: T)
    fun onError(error: Any)
}