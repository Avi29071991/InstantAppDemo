package com.avinash.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Avinash Mandal on 27/10/2017.
 */
class WeatherMain {

    @SerializedName("daily")
    @Expose
    private var daily: DailyMain? = null


    fun getDaily(): DailyMain? {
        return daily
    }

    fun setDaily(daily: DailyMain) {
        this.daily = daily
    }
}
