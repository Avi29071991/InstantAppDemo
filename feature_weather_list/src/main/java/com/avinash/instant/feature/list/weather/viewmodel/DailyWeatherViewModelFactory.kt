package com.avinash.instant.feature.list.weather.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.avinash.instantapp.base.model.DailyWeatherDataModel

/**
 * Class derived from {link@  ViewModelProvider.Factory} used in {link@ WeatherDetailsActivity} to provide detail weather data
 */
class DailyWeatherViewModelFactory(dailyData: DailyWeatherDataModel) : ViewModelProvider.Factory {

    var dailyDataData: DailyWeatherDataModel?= dailyData

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyDetailViewModel::class.java)) {
            return dailyDataData.let { DailyDetailViewModel(it!!) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}