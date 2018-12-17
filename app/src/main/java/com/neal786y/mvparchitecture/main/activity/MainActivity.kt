package com.neal786y.mvparchitecture.main.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.neal786y.mvparchitecture.main.presenter.MainPresenter
import com.neal786y.mvparchitecture.main.view.MainView
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.base.BaseActivity
import com.neal786y.mvparchitecture.base.component
import com.neal786y.mvparchitecture.base.isNetworkAvailable
import com.neal786y.mvparchitecture.base.showShortToast
import com.neal786y.mvparchitecture.main.adaper.NewsAdapter
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var retrofit: Retrofit

    var adapter: NewsAdapter? = null

    override fun getLayout(): Int = R.layout.activity_main

    override fun initPresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        initView()

        if(isNetworkAvailable()) onNetworkAvailable()
        else onNetworkLost()
    }

    private fun initView() {
        adapter = NewsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onLoad(data: Any) {
        when(data){
            is NewsResponse -> adapter?.addAll(data.articles)
        }
    }

    override fun onError(error: Any) {
        Log.d(TAG, "Error!!")
    }

    override fun onNetworkAvailable() {
        presenter?.loadNews(retrofit)
    }

    override fun onNetworkLost() {
        showShortToast("No internet connection")
    }
}
