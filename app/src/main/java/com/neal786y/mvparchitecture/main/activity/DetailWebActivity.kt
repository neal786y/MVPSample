package com.neal786y.mvparchitecture.main.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.base.BaseActivity
import com.neal786y.mvparchitecture.base.component
import com.neal786y.mvparchitecture.main.presenter.DetailWebPresenter
import com.neal786y.mvparchitecture.main.view.DetailWebView
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailWebActivity : BaseActivity<DetailWebView, DetailWebPresenter>() {

    @Inject
    lateinit var detailWebPresenter: DetailWebPresenter

    override fun getLayout(): Int = R.layout.activity_detail

    override fun initPresenter(): DetailWebPresenter = detailWebPresenter

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        val detailUrl = intent?.extras?.getString(getString(R.string.detailUrlKey))
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        detailUrl?.let {
            webView.loadUrl(detailUrl)
        }
    }

    override fun hideLoading() {}

    override fun showLoading() {}

    override fun onLoad(data: Any) {}

    override fun onError(error: Any) {}

    override fun onNetworkAvailable() {}

    override fun onNetworkLost() {}
}