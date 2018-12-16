package com.neal786y.mvparchitecture.base

import com.neal786y.mvparchitecture.network.NetworkChangeHandler
import com.neal786y.mvparchitecture.network.NetworkChangeListener
import com.neal786y.mvparchitecture.network.NetworkDetails

abstract class BasePresenter <V : BaseView<Any>> : Presenter<V>, NetworkChangeListener {

    var mView : V? = null

    override fun attachView(view: V) {
        mView = view
        NetworkChangeHandler.handler.registerNetworkChangeListener(this)
    }

    override fun detachView() {
        mView = null
    }

    override fun onAvailable(network: NetworkDetails) {
        mView?.onNetworkAvailable()
    }

    override fun onLost(network: NetworkDetails) {
        mView?.onNetworkLost()
    }
}