package com.neal786y.mvparchitecture.network

import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.support.annotation.RequiresApi

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class NetworkChangeCallback : ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        val detail = NetworkDetails()
        detail.isAvailable = true
        NetworkChangeHandler.handler.notifyNetworkAvailble(detail)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        val detail = NetworkDetails()
        detail.isAvailable = true
        NetworkChangeHandler.handler.notifyNetworkLost(detail)
    }
}
