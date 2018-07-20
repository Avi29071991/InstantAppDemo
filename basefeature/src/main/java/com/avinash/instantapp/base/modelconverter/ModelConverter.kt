package com.avinash.instantapp.base.modelconverter

import com.avinash.weatherapp.model.Daily
import com.avinash.weatherapp.network.model.DailyData

/**
 * Class used to convert list of daily weather data from server into list of data objects which contains only required fields
 */
class ModelConverter {

    fun dailyDataList(dailyData: List<DailyData>): List<Daily> {
        var list: ArrayList<Daily> = ArrayList()
        dailyData.mapTo(list) {
            Daily.Builder()
                    .time(it.getTime())
                    .summary(it.getSummary() as String)
                    .icon(it.getIcon() as String)
                    .sunriseTime(it.getSunriseTime())
                    .sunsetTime(it.getSunsetTime())
                    .temperatureMin(it.getTemperatureMin())
                    .temperatureMinTime(it.getTemperatureMinTime())
                    .temperatureMax(it.getTemperatureMax())
                    .temperatureMaxTime(it.getTemperatureMaxTime())
                    .dewPoint(it.getDewPoint())
                    .humidity(it.getHumidity())
                    .windSpeed(it.getWindSpeed())
                    .pressure(it.getPressure())
                    .ozone(it.getOzone())
                    .build()
        }

        return list
    }
}