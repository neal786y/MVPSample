package com.neal786y.mvparchitecture.splash.activity

import android.content.Intent
import android.os.Bundle
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.base.BaseActivity
import com.neal786y.mvparchitecture.base.component
import com.neal786y.mvparchitecture.main.activity.MainActivity
import com.neal786y.mvparchitecture.splash.presenter.SplashPresenter
import com.neal786y.mvparchitecture.splash.view.SplashView
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashView, SplashPresenter>() {

    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun getLayout(): Int  = R.layout.activity_spalsh

    override fun initPresenter(): SplashPresenter = splashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun hideLoading() {}

    override fun showLoading() {}

    override fun onLoad(data: Any) {}

    override fun onError(error: Any) {}

    override fun onNetworkAvailable() {}

    override fun onNetworkLost() {}
}