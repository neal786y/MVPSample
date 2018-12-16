package com.neal786y.mvparchitecture.network

import java.util.ArrayList
import java.util.Collections

class NetworkChangeHandler {
    internal var listeners: MutableList<NetworkChangeListener> = Collections.synchronizedList(ArrayList())
    fun registerNetworkChangeListener(listener: NetworkChangeListener) {
        synchronized(this) {
            listeners.add(listener)
        }
    }

    fun unregisterNetworkChangeListener(listener: NetworkChangeListener) {
        synchronized(this) {
            listeners.remove(listener)
        }
    }

    fun notifyNetworkAvailble(network: NetworkDetails) {
        synchronized(this) {
            for (i in listeners.indices)
                listeners[i].onAvailable(network)
        }
    }

    fun notifyNetworkLost(network: NetworkDetails) {
        synchronized(this) {
            for (i in listeners.indices)
                listeners[i].onLost(network)
        }
    }

    companion object {
        val handler = NetworkChangeHandler()
    }
}
