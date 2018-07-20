package com.avinash.weatherapp.network.datasource

import com.avinash.weatherapp.network.model.DailyData
import rx.Observable

interface ApiDataSource {

    /**
     * Returns the Observable API using retrofit for fetching the current weather data depending upon the latitude and longitude provided.

     * @param key API Key for calling forecast.io API.
     * *
     * @param lat latitude of the location.
     * *
     * @param lng longitude of the location.
     */
    fun fetchCurrentWeather(key: String, lat: Double,
                            lng: Double): Observable<List<DailyData>?>?

}