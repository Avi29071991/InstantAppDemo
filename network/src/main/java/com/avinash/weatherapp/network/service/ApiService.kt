package com.avinash.weatherapp.network.service

import com.avinash.weatherapp.network.model.WeatherMain
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

public interface ApiService {

    /**
     * Returns the Observable API using retrofit for fetching the current weather data depending upon the latitude and longitude provided.

     * @param key API Key for calling forecast.io API.
     * *
     * @param lat latitude of the location.
     * *
     * @param lng longitude of the location.
     */
    @GET("{api_key}/{latitude},{longitude}")
    fun fetchCurrentWeather(@Path("api_key") key: String, @Path("latitude") lat: Double,
                            @Path("longitude") lng: Double): Observable<WeatherMain>

}