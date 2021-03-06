package com.neal786y.mvparchitecture.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.neal786y.mvparchitecture.App
import com.neal786y.mvparchitecture.R
import com.neal786y.mvparchitecture.di.component.ApiComponent

val AppCompatActivity.component: ApiComponent
    get() = (application as App).component

fun AppCompatActivity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.isNetworkAvailable(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}

fun ImageView.loadImageUrl(url: String?){
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.placeholder))
        .into(this)

}