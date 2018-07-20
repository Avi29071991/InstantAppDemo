package com.avinash.instantapp.base.data

import android.content.Context
import android.net.ConnectivityManager
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instantapp.base.modelconverter.ModelConverter
import com.avinash.weatherapp.model.Daily
import com.avinash.weatherapp.network.datasource.ApiDataSource
import com.avinash.weatherapp.network.exception.NetworkException
import rx.Observable
import javax.inject.Inject

/**
 * Class used to performing fetching data from server and providing it to respective modules
 */
class DataProvider @Inject constructor(apiDataSource: ApiDataSource, modelConverter: ModelConverter, context: Context) {

    var mApiDataSource: ApiDataSource = apiDataSource
    var mModelConverter: ModelConverter = modelConverter
    var mContext: Context = context

    /**
     * Method used to perform network call depending on the condition of network availability of the device
     * @param observable {link @rx.Observable} object of service call
     *
     * @return {link @rx.Observable} object containing response from service call
     */
    private fun <R> networkDependencyCall(observable: Observable<R>): Observable<R> {

        return if (isDeviceOnline(mContext)) {
            observable.onErrorResumeNext { throwable ->
                //throw error back to subscriber
                Observable.error<R>(throwable)
            }.doOnNext {
                // additional actions you need to implement if required
            }
        } else {
            Observable.error(NetworkException(0, "Device Offline"))
        }
    }

    /**
     * Method used to check if the network connection is turned on in the device
     * @param context Context
     *
     * @return Boolean value whether device is in online state
     */
    fun isDeviceOnline(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    /**
     * Method to fetch weather details from server depending on the location latitude and longitude
     * @param key API key
     * @param lat latitude of the location
     * @param lng longitude of the location
     *
     * @return {link @rx.Observable} object containing list of daily weather details
     */
    fun fetchCurrentWeather(key: String, lat: Double, lng: Double): Observable<List<Daily>?> {
        return networkDependencyCall(mApiDataSource.fetchCurrentWeather(key, lat, lng)?.map {
            it?.let {
                mModelConverter.dailyDataList(it)
            }
        } as Observable<List<Daily>?>)
    }

    /**
     * Method for converting data objects into data model objects which can be further used to be converted into view model for data binding
     * @param list List of daily data objects returned from server
     *
     * @return Observable with a list of data model objects
     */
    fun processWeatherList(list: List<Daily>?): Observable<List<DailyWeatherDataModel>> {
        return Observable.create({ subscriber ->
            val dailyList = ArrayList<DailyWeatherDataModel>()
            if (list != null) {
                list.mapTo(dailyList) { DailyWeatherDataModel(it) }
                subscriber.onNext(dailyList)
            } else {
                subscriber.onError(Exception())
            }
            subscriber.onCompleted()
        })
    }
}