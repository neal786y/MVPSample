package com.neal786y.mvparchitecture.main.activity

import android.os.Bundle
import android.util.Log
import com.neal786y.mvparchitecture.main.presenter.MainPresenter
import com.neal786y.mvparchitecture.main.view.MainView
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.base.BaseActivity
import com.neal786y.mvparchitecture.base.component
import com.neal786y.mvparchitecture.base.isNetworkAvailable
import com.neal786y.mvparchitecture.base.showShortToast
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var retrofit: Retrofit

    override fun getLayout(): Int = R.layout.activity_main

    override fun initPresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        if(isNetworkAvailable()) onNetworkAvailable()
        else onNetworkLost()
    }

    override fun hideLoading() {}

    override fun showLoading() {}

    override fun onLoad(data: Any) {
        Log.d(TAG, data.toString())
        showShortToast("Data available")
    }

    override fun onError(error: Any) {
        Log.d(TAG, "Error!!")
        showShortToast("Error")
    }

    override fun onNetworkAvailable() {
        showShortToast("internet connection available")
        presenter?.loadNews(retrofit)
    }

    override fun onNetworkLost() {
        showShortToast("No internet connection")
    }
}
