package com.neal786y.mvparchitecture.main.interactor

import com.neal786y.mvparchitecture.base.Constants
import com.neal786y.mvparchitecture.base.Interactor
import com.neal786y.mvparchitecture.base.ResponseCallback
import com.neal786y.mvparchitecture.di.ApiInterface
import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainInteractor(retrofit: Retrofit) : Interactor<NewsResponse> {

    val mRetrofit = retrofit

    var mNewsResponseCallback: ResponseCallback<NewsResponse>? = null

    override fun run() {

        val apiClient = mRetrofit.create<ApiInterface>(ApiInterface::class.java)

        val call = apiClient.getNewsData("espn-cric-info", Constants.API_KEY)

        call.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                onSuccess(response.body() as NewsResponse)
            }

        })
    }

    override fun onSuccess(response: NewsResponse) {
        mNewsResponseCallback?.onSuccess(response)
    }

    override fun onError(error: Any) {
        mNewsResponseCallback?.onError(error)
    }
}