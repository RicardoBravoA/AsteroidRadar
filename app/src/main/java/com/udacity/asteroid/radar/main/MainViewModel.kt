package com.udacity.asteroid.radar.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroid.radar.network.AsteroidRadarApi
import com.udacity.asteroid.radar.util.Constants
import com.udacity.asteroid.radar.util.NetworkStatus
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus>
        get() = _status

    init {
        getFeed("2020-11-12", "2020-11-12")
    }

    private fun getFeed(startDate: String, endDate: String) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
//                _properties.value = AsteroidRadarApi.retrofitService.feed(startDate, endDate)
//                val value = AsteroidRadarApi.retrofitService.feed(startDate, endDate)
                val value = Constants.DATA_RESPONSE
                Log.i("z- value", value)
                _status.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _status.value = NetworkStatus.ERROR
                Log.i("z- value", "${e.toString()}")
//                _properties.value = ArrayList()
            }
        }
    }

}