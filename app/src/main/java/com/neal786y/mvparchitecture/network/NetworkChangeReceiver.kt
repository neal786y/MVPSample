package com.neal786y.mvparchitecture.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo

import android.content.Context.CONNECTIVITY_SERVICE

class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent == null || intent.extras == null)
            return

        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo != null && networkInfo.state == NetworkInfo.State.CONNECTED) {
            val detail = NetworkDetails()
            detail.isAvailable = true
            NetworkChangeHandler.handler.notifyNetworkAvailble(detail)
        } else {
            val detail = NetworkDetails()
            detail.isAvailable = false
            NetworkChangeHandler.handler.notifyNetworkLost(detail)
        }
    }
}
