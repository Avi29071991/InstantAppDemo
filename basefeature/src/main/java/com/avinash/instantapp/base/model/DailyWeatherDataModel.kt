package com.avinash.instantapp.base.model


import com.avinash.instantapp.base.utils.Utilities
import com.avinash.weatherapp.model.Daily
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Data model class used to convert values returned from the server into meaningful user readable format
 */
class DailyWeatherDataModel constructor(dailyWeather: Daily) : Serializable {

    var dailyWeatherData: Daily? = dailyWeather

    /**
     * Method to provide weather icon name
     */
    fun getIcon(): String? {
        return getDailyData()?.icon ?: run { "" }
    }

    /**
     * Method to provide weather condition
     */
    fun getSummary(): String? {
        return getDailyData()?.summary ?: run { "" }
    }

    /**
     * Method to provide date for which weather details are displayed
     */
    fun getDate(): String {
        getDailyData()?.time?.let {
            val date = Date(it * 1000)
            val df2 = SimpleDateFormat("EEE dd/MM/yyyy", Locale.US)
            val dateText = df2.format(date)
            if (Utilities.isNotEmpty(dateText)) {
                val s = dateText.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                s.indices
                        .filter { it == 1 }
                        .forEach { return s[it] }
            }
        }
        return ""
    }

    /**
     * Method used to provide day of the particular date
     */
    fun getDay(): String {
        getDailyData()?.time?.let {
            val date = Date(it * 1000)
            val df2 = SimpleDateFormat("EEE dd/MM/yyyy", Locale.US)
            val dateText = df2.format(date)
            if (Utilities.isNotEmpty(dateText)) {
                val s = dateText.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                s.indices
                        .filter { it == 0 }
                        .forEach { return s[it] }
            }
        }
        return ""
    }

    /**
     * Method used to provide maximum temperature for given date
     */
    fun getMaxTemperature(): String {
        return getDailyData()?.temperatureMax?.let { Utilities.convertFarheniteToCelcius(it).toString() } ?: run { "" }
    }

    /**
     * Method used to provide minimum temperature for given date
     */
    fun getMinTemperature(): String {
        return getDailyData()?.temperatureMin?.let { Utilities.convertFarheniteToCelcius(it).toString() } ?: run { "" }
    }

    /**
     * Method used to provide dew point for given date
     */
    fun getDewPoint(): String {
        return getDailyData()?.dewPoint?.let { Utilities.convertFarheniteToCelcius(it).toString() } ?: run { "" }
    }

    /**
     * Method used to provide wind speed for given date
     */
    fun getWindSpeed(): String {
        return getDailyData()?.windSpeed?.let {
            val builder = StringBuilder(it.toString())
            builder.append(" Km/hr")
            builder.toString()
        } ?: run { "" }
    }

    /**
     * Method used to provide humidity for given date
     */
    fun getHumidity(): String {
        return getDailyData()?.humidity?.let {
            val builder = StringBuilder(it.toString())
            builder.append("%")
            builder.toString()
        } ?: run { "" }
    }

    /**
     * Method used to provide ozone value for given date
     */
    fun getOzone(): String {
        return getDailyData()?.ozone?.let {
            val builder = StringBuilder(it.toString())
            builder.append("DU")
            builder.toString()
        } ?: run { "" }
    }

    /**
     * Method used to provide pressure for given date
     */
    fun getPressure(): String {
        return getDailyData()?.pressure?.let {
            val builder = StringBuilder(it.toString())
            builder.append("hPa")
            builder.toString()
        } ?: run { "" }
    }

    /**
     * Method used to provide daily data object
     */
    fun getDailyData(): Daily? {
        return dailyWeatherData
    }

}







