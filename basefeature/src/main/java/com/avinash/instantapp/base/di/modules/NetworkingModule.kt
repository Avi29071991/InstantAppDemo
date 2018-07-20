package com.avinash.instantapp.base.di.modules

import android.os.Build
import android.support.annotation.RequiresApi
import com.avinash.instantapp.base.modelconverter.ModelConverter
import com.avinash.instantapp.base.utils.Constants
import com.avinash.weatherapp.network.service.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import javax.inject.Singleton
import java.util.logging.Logger
import javax.net.ssl.*
import com.google.gson.GsonBuilder

/**
 * {link @dagger.Module} class for providing network and model converter related dependencies
 */
@Module
class NetworkingModule {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Provides
    @Singleton
    fun providesOkHttpClientInstance(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.addInterceptor { chain ->
            val response = chain.proceed(chain.request())
            response
        }
        httpBuilder.connectTimeout(Constants.CONNECTION_READ_TIMEOUT, TimeUnit.MILLISECONDS)
        httpBuilder.readTimeout(Constants.CONNECTION_READ_TIMEOUT, TimeUnit.MILLISECONDS)
        var sslSocketFactory = getSslSocketFactory()
        if (sslSocketFactory == null) {
            sslSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory()
        }
        sslSocketFactory.let { httpBuilder.sslSocketFactory(it) }

        return httpBuilder.build()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(Constants.BASE_WEATHER_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setPrettyPrinting().create()))
                .build()
    }

    @Provides
    @Singleton
    fun providesApiInstance(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesModelConverter(): ModelConverter {
        return ModelConverter()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun getSslSocketFactory(): SSLSocketFactory? {
        var sslSocketFactory: SSLSocketFactory? = null

        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {//Default method not implemented
            }

            override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {//Default method not implemented
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }

        })

        // Install the all-trusting trust manager
        var sslContext: SSLContext?

        try {
            sslContext = SSLContext.getInstance("SSL")
            sslContext!!.init(null, trustAllCerts, java.security.SecureRandom())
        } catch (e: NoSuchAlgorithmException) {
            Logger.getGlobal().log(Level.SEVERE, "SSL instance could not be found.", e)
            sslContext = null
        } catch (e: KeyManagementException) {
            Logger.getGlobal().log(Level.SEVERE, "There was a problem initialising SSL instance", e)
            sslContext = null
        }

        if (sslContext != null) {
            // Create an ssl socket factory with our all-trusting manager
            sslSocketFactory = sslContext.socketFactory
        }
        return sslSocketFactory
    }
}