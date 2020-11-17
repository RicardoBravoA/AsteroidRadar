package com.udacity.asteroid.radar.main

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroid.radar.database.AsteroidDatabase
import com.udacity.asteroid.radar.repository.AsteroidRepository
import com.udacity.asteroid.radar.repository.PictureOfTheDayRepository
import com.udacity.asteroid.radar.util.NetworkStatus
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

    private val database = AsteroidDatabase.getDatabase(application.baseContext)
    private val asteroidRepository = AsteroidRepository(database)
    private val pictureOfTheDayRepository = PictureOfTheDayRepository(database)

    init {
//        getFeed("2020-11-16", "2020-11-23")
        getData("2020-11-17", "2020-11-24")
    }

    private fun getData(startDate: String, endDate: String) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
                delay(500)
                coroutineScope {
//                    val items = NetworkUtils.parseStringToAsteroidList(context)
//                    val picture = NetworkUtils.parseImageOfTheDay(context)
                    asteroidRepository.refreshAsteroids(startDate, endDate)
                    pictureOfTheDayRepository.refreshPicture()
                    val items = asteroidRepository.asteroidList.value
                    val picture = pictureOfTheDayRepository.pictureOfTheDay.value

                    val list = mutableListOf<MainItem>()
                    list.add(MainItem.Picture(picture!!.url, picture.mediaType))

                    items!!.forEach {
                        list.add(MainItem.Item(it))
                    }
                    _asteroidList.postValue(list)
                    _status.value = NetworkStatus.DONE
                }
            } catch (e: java.lang.Exception) {
                _asteroidList.value = arrayListOf()
                _status.value = NetworkStatus.ERROR
            }
        }
    }

    /*private fun getFeed(startDate: String, endDate: String, context: Context) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
                coroutineScope {
                    val itemsString = ApiManager.get().feed(startDate, endDate)
                    val items = NetworkUtils.parseStringToAsteroidList(itemsString)
                    val picture = ApiManagerMoshi.get().pictureOfTheDay()

                    val list = mutableListOf<MainItem>()
                    list.add(MainItem.Picture(picture.url))

                    items.forEach {
                        list.add(MainItem.Item(it))
                    }
                    _asteroidList.postValue(list)
                    _status.value = NetworkStatus.DONE
                }
            } catch (e: Exception) {
                _asteroidList.value = arrayListOf()
                _status.value = NetworkStatus.ERROR
            }
        }
    }*/

}