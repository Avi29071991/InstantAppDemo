package com.avinash.instant.feature.list.weather.presentation.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.avinash.instant.feature.list.weather.R
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instant.feature.list.weather.viewmodel.DailyDetailViewModel
import com.avinash.instant.feature.list.weather.viewmodel.DailyWeatherViewModelFactory
import com.avinash.instant.feature.list.weather.viewmodel.WeatherBindings

/**
 * Activity for displaying details of weather conditions.
 * Demonstrating the use of Android Architecture like ViewModel, ViewModelProvider.Factory and Lifecycle.
 */
class WeatherDetailsActivity : BaseWeatherFeatureActivity() {

    private var weatherDataDetailData: DailyWeatherDataModel? = null
    private var weatherIcon: ImageView? = null
    private var tvDay: TextView? = null
    private var tvDate: TextView? = null
    private var tvCon: TextView? = null
    private var tvMinTemp: TextView? = null
    private var tvMaxTemp: TextView? = null
    private var tvHumidity: TextView? = null
    private var tvWindSpeed: TextView? = null
    private var tvPressure: TextView? = null
    private var tvDewPoint: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.run {
            initialize()
            setWeatherData()
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_weather_details
    }

    private fun initialize() {
        weatherDataDetailData = getWeatherDailyData()
        initializeUIComponents()
    }

    /**
     * Using {link @ViewModel} and {link @ ViewModelProvider.Factory} of Android architecture component to display detailed weather conditions
     */
    private fun setWeatherData() {
        val dataFactory: DailyWeatherViewModelFactory = weatherDataDetailData?.let { DailyWeatherViewModelFactory(it) }!!
        val dailyDetailViewModel: DailyDetailViewModel = ViewModelProviders.of(this, dataFactory).get(DailyDetailViewModel::class.java)
        dailyDetailViewModel.getDailyWeatherData().observe(this, Observer { it ->
            it?.let { it1 ->
                setUIValues(it1)
            }
        })
    }

    private fun getWeatherDailyData(): DailyWeatherDataModel? {
        return intent?.extras?.getSerializable(DATA_KEY) as DailyWeatherDataModel?
    }

    /**
     * Need to initialize UI elements as kotlin synthtic view extensions not supported for non-base feature module.
     * Also Data binding is not supported for non-base feature module, but according to some android blog-post these features
     * are supported in Android Studio 3.1.0 and above .... Need to test
     */
    private fun initializeUIComponents() {
        weatherIcon = findViewById(R.id.weather_icon)
        tvDay = findViewById(R.id.tvDay)
        tvDate = findViewById(R.id.tvDate)
        tvCon = findViewById(R.id.textCon)
        tvMaxTemp = findViewById(R.id.tvMaxTemp)
        tvMinTemp = findViewById(R.id.tvMinTemp)
        tvHumidity = findViewById(R.id.tvHumidity)
        tvDewPoint = findViewById(R.id.tvDewPoint)
        tvPressure = findViewById(R.id.tvPressure)
        tvWindSpeed = findViewById(R.id.tvWindSpeed)
    }

    /**
     * TODO: need to test data binding on Android Studio 3.1.0 and above to remove this block of code
     */
    private fun setUIValues(data: DailyWeatherDataModel) {
        WeatherBindings.setWeatherIcon(weatherIcon, data.getIcon()!!)
        WeatherBindings.setTemparature(tvMaxTemp, data.getMaxTemperature())
        WeatherBindings.setTemparature(tvMinTemp, data.getMinTemperature())
        WeatherBindings.setText(tvDay, data.getDay())
        WeatherBindings.setText(tvDate, data.getDate())
        WeatherBindings.setText(tvCon, data.getSummary()!!)
        WeatherBindings.setText(tvHumidity, data.getHumidity())
        WeatherBindings.setText(tvDewPoint, data.getDewPoint())
        WeatherBindings.setText(tvPressure, data.getPressure())
        WeatherBindings.setText(tvWindSpeed, data.getWindSpeed())
    }

    companion object {
        val DATA_KEY = "dataKey"
    }
}