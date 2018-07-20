package com.avinash.instant.feature.list.weather.presentation.presenter

import android.location.Location
import android.util.Log
import com.avinash.instant.feature.list.weather.usecase.GetWeatherListUseCase
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instantapp.base.model.DefaultSubscriber
import com.avinash.instantapp.base.presentation.presenter.BasePresenter
import com.avinash.instant.feature.list.weather.presentation.view.WeatherView
import com.avinash.instant.feature.list.weather.utils.Codes
import com.avinash.weatherapp.network.exception.NetworkException
import rx.Subscriber

/**
 * Presenter class used to perform business logic for fetching and displaying weather details
 */
class WeatherPresenter constructor(weatherView: WeatherView, weatherUseCase: GetWeatherListUseCase) : BasePresenter {

    val view: WeatherView = weatherView
    private val useCase: GetWeatherListUseCase = weatherUseCase

    override fun destroy() {
        useCase.unSubscribe()
    }

    /**
     * Method used to fetch weather details for ap particular location
     */
    fun dataGetWeatherDetails(location: Location?) {
        location?.let {
            useCase.setApiKey(Codes.API_KEY)
            Log.d("latitude", it.latitude.toString())
            Log.d("longitude", it.longitude.toString())
            useCase.setLatitude(it.latitude)
            useCase.setLongitude(it.longitude)
            useCase.execute(WeatherSubscriber(view) as Subscriber<Any>)
        }
    }

    /**
     * Subscriber class used to provide result of network call for weather service
     */
    class WeatherSubscriber(var view: WeatherView) : DefaultSubscriber<List<DailyWeatherDataModel>>() {
        override fun onNext(t: List<DailyWeatherDataModel>) {
            view.hideProgressBar()
            view.showErrorMessage(false, null)
            view.showWeatherData(t)
            view.showList(true)
        }

        override fun onError(e: Throwable) {
            Log.e("WeatherPresenter", e.message, e)
            view.hideProgressBar()
            view.showList(false)
            if (e is NetworkException) {
                view.displayNetworkError()
            } else {
                view.showErrorMessage(true, "Something went wrong")
            }
        }
    }
}