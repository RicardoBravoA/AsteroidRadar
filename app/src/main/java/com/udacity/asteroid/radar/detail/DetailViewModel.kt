package com.udacity.asteroid.radar.detail

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroid.radar.mapper.DetailMapper
import com.udacity.asteroid.radar.model.Asteroid

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _detailItemList = MutableLiveData<List<DetailModel>>()
    val detailItemList: LiveData<List<DetailModel>>
        get() = _detailItemList

    fun transformData(asteroid: Asteroid) {
        _detailItemList.value =
            DetailMapper.transform(getApplication<Application>().baseContext, asteroid)

    }

}