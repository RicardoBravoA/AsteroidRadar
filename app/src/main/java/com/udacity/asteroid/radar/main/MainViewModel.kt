package com.udacity.asteroid.radar.main

import androidx.lifecycle.*
import com.udacity.asteroid.radar.data.util.DataDateUtil
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.usecase.AsteroidOfflineUseCase
import com.udacity.asteroid.radar.domain.usecase.AsteroidUseCase
import com.udacity.asteroid.radar.domain.usecase.PictureOfflineUseCase
import com.udacity.asteroid.radar.domain.usecase.PictureUseCase
import com.udacity.asteroid.radar.domain.util.ResultType
import com.udacity.asteroid.radar.mapper.MainMapper
import com.udacity.asteroid.radar.util.NetworkStatus
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val asteroidUseCase: AsteroidUseCase,
    private val pictureUseCase: PictureUseCase,
    private val pictureOfflineUseCase: PictureOfflineUseCase,
    private val asteroidOfflineUseCase: AsteroidOfflineUseCase
) : ViewModel() {

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus>
        get() = _status

    private val _asteroidList = MutableLiveData<List<MainItem>>()
    val asteroidList: LiveData<List<MainItem>>
        get() = _asteroidList

    init {
        getData(
            DataDateUtil.currentDate(),
            DataDateUtil.currentDate(DataDateUtil.DEFAULT_END_DATE_DAYS)
        )
    }

    fun weekData() {
        getData(
            DataDateUtil.currentDate(),
            DataDateUtil.currentDate(DataDateUtil.DEFAULT_END_DATE_DAYS)
        )
    }

    fun today() {
        getData(
            DataDateUtil.currentDate(),
            DataDateUtil.currentDate()
        )
    }

    fun saved() {
        getData(
            DataDateUtil.currentDate(),
            DataDateUtil.currentDate(DataDateUtil.DEFAULT_END_DATE_DAYS),
            true
        )
    }

    private fun getData(startDate: String, endDate: String, isSavedData: Boolean = false) {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING

            try {
                coroutineScope {

                    var items = listOf<AsteroidModel>()
                    var picture: PictureModel? = null

                    if (isSavedData) {
                        when (val result = pictureOfflineUseCase.get()) {
                            is ResultType.Success -> {
                                picture = result.value
                            }
                            is ResultType.Error -> {
                                //Do nothing
                            }
                        }
                    } else {
                        when (val result = pictureUseCase.get()) {
                            is ResultType.Success -> {
                                picture = result.value
                            }
                            is ResultType.Error -> {
                                //Do nothing
                            }
                        }
                    }

                    if (isSavedData) {
                        when (val result = asteroidOfflineUseCase.list(startDate, endDate)) {
                            is ResultType.Success -> {
                                items = result.value
                            }
                            is ResultType.Error -> {
                                //Do nothing
                            }
                        }
                    } else {
                        when (val result = asteroidUseCase.list(startDate, endDate)) {
                            is ResultType.Success -> {
                                items = result.value
                            }
                            is ResultType.Error -> {
                                //Do nothing
                            }
                        }
                    }

                    _asteroidList.postValue(MainMapper.transform(items, picture))
                    _status.value = NetworkStatus.DONE
                }
            } catch (e: Exception) {
                _asteroidList.value = arrayListOf()
                _status.value = NetworkStatus.ERROR
            }
        }
    }

}