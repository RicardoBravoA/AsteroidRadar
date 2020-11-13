package com.udacity.asteroid.radar.detail

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroid.radar.mapper.DetailMapper
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.model.DetailItem

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _detailItemList = MutableLiveData<List<DetailItem>>()
    val detailItemList: LiveData<List<DetailItem>>
        get() = _detailItemList

    fun transformData(asteroid: Asteroid) {
        val list: List<DetailItem> =
            DetailMapper.transform(getApplication<Application>().baseContext, asteroid)
        _detailItemList.value = list

    }

}