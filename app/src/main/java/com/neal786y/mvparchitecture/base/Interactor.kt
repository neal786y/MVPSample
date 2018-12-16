package com.neal786y.mvparchitecture.base

interface Interactor<T> {

    fun run()
    fun onSuccess(response: T)
    fun onError(error: Any)
}