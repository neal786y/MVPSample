package com.neal786y.mvparchitecture

import android.app.Application
import android.content.Context
import com.neal786y.mvparchitecture.di.component.ApiComponent
import com.neal786y.mvparchitecture.di.module.ApiModule
import com.neal786y.mvparchitecture.di.module.AppModule
import com.neal786y.mvparchitecture.network.NetworkChangeCallback
import android.net.NetworkRequest
import android.net.ConnectivityManager
import android.os.Build
import com.neal786y.mvparchitecture.di.component.DaggerApiComponent


class App : Application() {

    lateinit var component: ApiComponent

    override fun onCreate() {
        super.onCreate()
        val baseUrl = getString(R.string.baseUrl)
        component = DaggerApiComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(baseUrl))
                .build()

        registerConnectivityNetworkMonitorForAPI21AndUp();

    }

    private fun registerConnectivityNetworkMonitorForAPI21AndUp() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return
        }

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()

        connectivityManager.registerNetworkCallback(builder.build(), NetworkChangeCallback())

    }
}