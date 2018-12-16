package com.neal786y.mvparchitecture.di

import com.neal786y.mvparchitecture.main.pojo.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/top-headlines")
    fun getNewsData(@Query("sources") sources: String, @Query("apiKey") apiKey: String): Call<NewsResponse>
}