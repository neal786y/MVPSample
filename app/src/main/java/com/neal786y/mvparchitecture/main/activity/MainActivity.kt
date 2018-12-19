package com.neal786y.mvparchitecture.main.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.base.BaseActivity
import com.neal786y.mvparchitecture.base.component
import com.neal786y.mvparchitecture.base.isNetworkAvailable
import com.neal786y.mvparchitecture.base.showShortToast
import com.neal786y.mvparchitecture.main.adaper.NewsAdapter
import com.neal786y.mvparchitecture.main.adaper.SourceAdapter
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import com.neal786y.mvparchitecture.main.presenter.MainPresenter
import com.neal786y.mvparchitecture.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    val TAG = MainActivity::class.java.simpleName

    var selectedResource: String = ""

    @Inject
    lateinit var retrofit: Retrofit

    var adapter: NewsAdapter? = null
    var sourceAdapter: SourceAdapter? = null

    override fun getLayout(): Int = R.layout.activity_main

    override fun initPresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        initView()

        if (isNetworkAvailable()) onNetworkAvailable()
        else onNetworkLost()
    }

    private fun initView() {

        selectedResource = getString(R.string.default_source)

        adapter = NewsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val sourceList = resources.getStringArray(R.array.sourceList).toCollection(ArrayList<String>())
        sourceAdapter = SourceAdapter()
        recyclerViewSource.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewSource.adapter = sourceAdapter
        sourceAdapter?.addAll(sourceList)

        sourceAdapter?.onSourceItemClickListener = object : SourceAdapter.OnSourceItemClickListener {
            override fun onSourceClick(source: String) {
                showLoading()
                selectedResource = source
                presenter?.loadNews(retrofit, selectedResource)
            }
        }
    }

    override fun hideLoading() {
        runOnUiThread {
            progressBar.visibility = View.GONE
        }
    }


    override fun showLoading() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun onLoad(data: Any) {
        runOnUiThread {
            when (data) {
                is NewsResponse -> adapter?.addAll(data.articles)
            }
        }
    }

    override fun onError(error: Any) {
        when (error) {
            is Throwable -> {
                showShortToast(getString(R.string.somethingWentWrong))
                Log.d(TAG, error.printStackTrace().toString())
            }
        }
    }

    override fun onNetworkAvailable() {
        showLoading()
        presenter?.loadNews(retrofit, selectedResource)
    }

    override fun onNetworkLost() {
        showShortToast(getString(R.string.no_internet_text))
    }
}
