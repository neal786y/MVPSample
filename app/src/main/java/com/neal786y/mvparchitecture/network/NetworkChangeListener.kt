package com.neal786y.mvparchitecture.network

interface NetworkChangeListener {
    fun onAvailable(network: NetworkDetails)
    fun onLost(network: NetworkDetails)
}

