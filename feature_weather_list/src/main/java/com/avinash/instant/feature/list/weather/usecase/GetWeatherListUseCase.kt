package com.avinash.instant.feature.list.weather.usecase

import com.avinash.instantapp.base.data.DataProvider
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instantapp.base.usecase.BaseUseCase
import rx.Observable

/**
 * Use case class used to fetch weather details from weather service
 */
class GetWeatherListUseCase constructor(dataProvider: DataProvider) : BaseUseCase() {

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var apiKey: String
    private val provider: DataProvider = dataProvider

    override fun buildUseCaseObservable(): Observable<List<DailyWeatherDataModel>> {
        return provider.fetchCurrentWeather(apiKey, latitude, longitude)
                .flatMap { provider.processWeatherList(it) }
    }

    fun setLatitude(lat: Double) {
        this.latitude = lat
    }

    fun setLongitude(lng: Double) {
        this.longitude = lng
    }

    fun setApiKey(key: String) {
        this.apiKey = key
    }

}