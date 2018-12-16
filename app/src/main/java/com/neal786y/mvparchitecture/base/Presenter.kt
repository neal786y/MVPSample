package com.neal786y.mvparchitecture.base

interface Presenter<V : BaseView<Any>> {

    fun attachView(view: V)

    fun detachView()

}