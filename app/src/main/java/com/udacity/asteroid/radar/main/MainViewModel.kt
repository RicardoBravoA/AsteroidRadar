package com.udacity.asteroid.radar.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.network.NetworkUtils
import com.udacity.asteroid.radar.util.NetworkStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus>
        get() = _status

    private val _asteroidList = MutableLiveData<List<Asteroid>>()

    val asteroidList: LiveData<List<Asteroid>>
        get() = _asteroidList

    init {
        getFeed("2020-11-12", "2020-11-19", application.baseContext)
    }

    private fun getFeed(startDate: String, endDate: String, context: Context) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
//                val value = AsteroidRadarApi.retrofitService.feed(startDate, endDate)
                delay(2000)
                _asteroidList.value = NetworkUtils.parseStringToAsteroidList(context)
                _status.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _status.value = NetworkStatus.ERROR
                Log.i("z- value", "${e.toString()}")
//                _properties.value = ArrayList()
            }
        }
    }

}