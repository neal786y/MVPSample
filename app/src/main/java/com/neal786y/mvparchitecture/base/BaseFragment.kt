package com.neal786y.mvparchitecture.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment<V : BaseView<Any>, P : BasePresenter<V>> : Fragment() {

    protected var presenter: P? = null

    protected abstract fun initPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.attachView(this as V)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        initDestroy()
    }

    fun initDestroy() {
        presenter?.detachView()
    }

}