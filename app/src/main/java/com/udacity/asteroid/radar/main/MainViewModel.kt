package com.udacity.asteroid.radar.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.model.ImageOfTheDay
import com.udacity.asteroid.radar.network.ApiManager
import com.udacity.asteroid.radar.network.ApiManagerMoshi
import com.udacity.asteroid.radar.util.NetworkStatus
import com.udacity.asteroid.radar.util.NetworkUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus>
        get() = _status

    private val _imageStatus = MutableLiveData<NetworkStatus>()
    val imageStatus: LiveData<NetworkStatus>
        get() = _imageStatus

    private val _asteroidList = MutableLiveData<List<Asteroid>>()
    val asteroidList: LiveData<List<Asteroid>>
        get() = _asteroidList

    private val _imageOfTheDay = MutableLiveData<ImageOfTheDay>()
    val imageOfTheDay: LiveData<ImageOfTheDay>
        get() = _imageOfTheDay

    init {
        getFeed("2020-11-12", "2020-11-19", application.baseContext)
        getImageOfTheDay()
    }

    private fun getFeed(startDate: String, endDate: String, context: Context) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
//                val value = ApiManager.get().feed(startDate, endDate)
                delay(2000)
                _asteroidList.value = NetworkUtils.parseStringToAsteroidList(context)
//                _asteroidList.value = NetworkUtils.parseStringToAsteroidList(value)
                _status.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _status.value = NetworkStatus.ERROR
                Log.i("z- value", e.toString())
                _asteroidList.value = arrayListOf()
            }
        }
    }

    private fun getImageOfTheDay() {
        viewModelScope.launch {
            _imageStatus.value = NetworkStatus.LOADING
            try {
                _imageOfTheDay.value = ApiManagerMoshi.get().imageOfTheDay()
                _imageStatus.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _imageStatus.value = NetworkStatus.ERROR
                Log.i("z- value", e.toString())
            }
        }
    }

}