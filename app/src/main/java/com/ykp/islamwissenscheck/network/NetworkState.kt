package com.ykp.islamwissenscheck.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun checkNetworkState(): Boolean {

    val context = LocalContext.current

    //instance of connectivityManager
    val connectivityManager = context.getSystemService(ConnectivityManager::class.java)

    //get a reference to the current default network
    val currentNetwork = connectivityManager.activeNetwork

    val caps = connectivityManager.getNetworkCapabilities(currentNetwork) ?: return false

    return when {
        caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        else -> {
            return false
        }
    }
}