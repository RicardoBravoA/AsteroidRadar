package com.udacity.asteroid.radar.data.util

import android.content.Context
import android.net.ConnectivityManager

fun Context.isInternet(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}