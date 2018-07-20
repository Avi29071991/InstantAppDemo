package com.avinash.instant.feature.list.weather.di.modules

import android.content.Context
import android.view.LayoutInflater
import com.avinash.instant.feature.list.weather.usecase.GetWeatherListUseCase
import com.avinash.instant.feature.list.weather.utils.Codes
import com.avinash.instantapp.base.data.DataProvider
import com.avinash.instantapp.base.di.FeatureScreenScope
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import dagger.Module
import dagger.Provides

/**
 * {link @dagger.Module} class for providing dependencies related Weather feature
 */
@Module
class WeatherListModule {


    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in appropriate class.
     */
    @FeatureScreenScope
    @Provides
    internal fun providesLocationRequestInstance(): LocationRequest {
        val locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        locationRequest.interval = Codes.LOCATION_INTERVAL_TIME
        locationRequest.fastestInterval = Codes.LOCATION_FASTEST_INTERVAL_TIME

        return locationRequest
    }

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in appropriate class.
     */
    @FeatureScreenScope
    @Provides
    internal fun providesGoogleApiClientBuilderInstance(context: Context): GoogleApiClient.Builder {
        return GoogleApiClient.Builder(context)
    }

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in appropriate class.
     */
    @FeatureScreenScope
    @Provides
    fun providesLayoutInflater(context: Context): LayoutInflater {
        return context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in appropriate class.
     */
    @FeatureScreenScope
    @Provides
    fun providesGetWeatherListUseCase(dataProvider: DataProvider): GetWeatherListUseCase {
        return GetWeatherListUseCase(dataProvider)
    }
}