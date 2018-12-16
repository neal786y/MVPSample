package com.neal786y.mvparchitecture.main.presenter

import com.neal786y.mvparchitecture.base.BasePresenter
import com.neal786y.mvparchitecture.base.ResponseCallback
import com.neal786y.mvparchitecture.main.interactor.MainInteractor
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import com.neal786y.mvparchitecture.main.view.MainView
import retrofit2.Retrofit

class MainPresenter : BasePresenter<MainView>() {

    fun loadNews(retrofit: Retrofit) {
        val mainInteractor = MainInteractor(retrofit);
        mainInteractor.mNewsResponseCallback = object : ResponseCallback<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                mView?.onLoad(response)
            }

            override fun onError(error: Any) {
                mView?.onError(error)
            }
        }

        mainInteractor.run()
    }
}