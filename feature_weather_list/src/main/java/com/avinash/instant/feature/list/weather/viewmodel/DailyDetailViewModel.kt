package com.avinash.instant.feature.list.weather.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.avinash.instantapp.base.model.DailyWeatherDataModel

/**
 * Class derived from {link@ ViewModel} used in {link@ WeatherDetailsActivity} to provide detail weather data
 */
class DailyDetailViewModel(dailyDetailData: DailyWeatherDataModel) : ViewModel() {

    private var dailyWeatherData = MutableLiveData<DailyWeatherDataModel>()

    init {
        dailyWeatherData.value = dailyDetailData
    }

    fun getDailyWeatherData(): LiveData<DailyWeatherDataModel> {
        return dailyWeatherData
    }
}