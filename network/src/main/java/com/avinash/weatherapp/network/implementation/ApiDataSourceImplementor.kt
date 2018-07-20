package com.avinash.weatherapp.network.implementation

import com.avinash.weatherapp.network.datasource.ApiDataSource
import com.avinash.weatherapp.network.model.DailyData
import rx.Observable
import com.avinash.weatherapp.network.service.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiDataSourceImplementor @Inject constructor(var apiService: ApiService) : ApiDataSource {

    private val NETWORK_CALL_TIMEOUT: Long = 30000
    private val mService: ApiService? = apiService

    //TODO need to check the implementation for ServiceInterceptor , CookieManager , OhHttpClient

    fun <R> serviceCall(observable: Observable<R>): Observable<R>? {
        return observable.onErrorResumeNext { throwable ->
            //throw error back to subscriber
            Observable.error<R>(throwable)
        }.doOnNext {
            // additional actions you need to implement if required
        }.timeout(NETWORK_CALL_TIMEOUT, TimeUnit.MILLISECONDS)
    }

    override fun fetchCurrentWeather(key: String, lat: Double, lng: Double): Observable<List<DailyData>?>? {
        return serviceCall(mService?.fetchCurrentWeather(key, lat, lng)?.map {
            it?.getDaily()?.getData()
        } as Observable<List<DailyData>?>)
    }

}