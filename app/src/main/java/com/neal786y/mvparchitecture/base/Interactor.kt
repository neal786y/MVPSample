package com.neal786y.mvparchitecture.base

import java.lang.Exception

interface Interactor<T> {

    fun run()
    fun onSuccess(response: T)
    fun onError(error: Any)
}