package com.avinash.instant.feature.list.weather.presentation.view

import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instantapp.base.presentation.view.BaseView

/**
 * Class used to provide view components for displaying weather details
 */
interface WeatherView : BaseView {

    fun displayNetworkError()

    fun showWeatherData(dataList: List<DailyWeatherDataModel>)

    fun showList(show: Boolean)
}