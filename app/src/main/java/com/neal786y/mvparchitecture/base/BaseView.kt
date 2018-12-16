package com.neal786y.mvparchitecture.base

interface BaseView<T> {

    fun hideLoading()

    fun showLoading()

    fun onLoad(data: T)

    fun onError(error: Any)

    fun onNetworkAvailable()

    fun onNetworkLost()
}