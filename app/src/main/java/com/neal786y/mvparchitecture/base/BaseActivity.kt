package com.neal786y.mvparchitecture.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V : BaseView<Any>, P : BasePresenter<V>> : AppCompatActivity(), BaseView<Any> {

    protected var presenter: P? = null

    protected abstract fun getLayout(): Int

    protected abstract fun initPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        presenter = initPresenter()
    }

    override fun onResume() {
        super.onResume()
        presenter?.attachView(this as V)

    }

    override fun onPause() {
        super.onPause()
        presenter?.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }
}