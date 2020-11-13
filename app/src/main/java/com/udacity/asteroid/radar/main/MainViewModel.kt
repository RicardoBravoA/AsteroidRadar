package com.udacity.asteroid.radar.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.udacity.asteroid.radar.model.PictureOfTheDay
import com.udacity.asteroid.radar.util.NetworkStatus
import com.udacity.asteroid.radar.util.NetworkUtils
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus>
        get() = _status

    private val _asteroidList = MutableLiveData<List<MainItem>>()
    val asteroidList: LiveData<List<MainItem>>
        get() = _asteroidList

    private val _imageOfTheDay = MutableLiveData<PictureOfTheDay>()
    val pictureOfTheDay: LiveData<PictureOfTheDay>
        get() = _imageOfTheDay

    init {
        /*getFeed("2020-11-12", "2020-11-19", application.baseContext)
        getImageOfTheDay(application.baseContext)*/
        getData(application.baseContext)
    }

    private fun getData(context: Context) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
                delay(500)
                coroutineScope {
                    val items = NetworkUtils.parseStringToAsteroidList(context)
                    val picture = NetworkUtils.parseImageOfTheDay(context)

                    val list = mutableListOf<MainItem>()
                    list.add(MainItem.Picture(picture.url))

                    items.forEach {
                        list.add(MainItem.Item(it))
                    }
                    _status.value = NetworkStatus.DONE

                    _asteroidList.postValue(list)
                }
            } catch (e: java.lang.Exception) {
                _status.value = NetworkStatus.ERROR
                _asteroidList.value = arrayListOf()
            }
        }
    }

    /*private fun getFeed(startDate: String, endDate: String, context: Context) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
//                val value = ApiManager.get().feed(startDate, endDate)
                delay(500)
                _asteroidList.value =
                    NetworkUtils.parseStringToAsteroidList(context)
//                _asteroidList.value = NetworkUtils.parseStringToAsteroidList(value)
                _status.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _status.value = NetworkStatus.ERROR
                Log.i("z- value", e.toString())
                _asteroidList.value = arrayListOf()
            }
        }
    }

    private fun getImageOfTheDay(context: Context) {
        viewModelScope.launch {
            _imageStatus.value = NetworkStatus.LOADING
            try {
//                _imageOfTheDay.value = ApiManagerMoshi.get().imageOfTheDay()
                delay(500)
                _imageOfTheDay.value = NetworkUtils.parseImageOfTheDay(context)
                _imageStatus.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _imageStatus.value = NetworkStatus.ERROR
                Log.i("z- value", e.toString())
            }
        }
    }*/

}