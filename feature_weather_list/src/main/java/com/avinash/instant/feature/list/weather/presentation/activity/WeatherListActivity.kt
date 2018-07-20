package com.avinash.instant.feature.list.weather.presentation.activity

import android.Manifest
import android.arch.lifecycle.Observer
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.avinash.instant.feature.list.weather.presentation.adapter.WeatherAdapter
import com.avinash.instantapp.base.di.Injectable
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instant.feature.list.weather.presentation.view.WeatherView
import com.avinash.instantapp.base.utils.Utilities
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ProgressBar
import android.widget.TextView
import com.avinash.instant.feature.list.weather.R
import com.avinash.instant.feature.list.weather.model.CurrentLocationListener
import com.avinash.instant.feature.list.weather.presentation.presenter.WeatherPresenter
import com.avinash.instant.feature.list.weather.usecase.GetWeatherListUseCase
import com.avinash.instant.feature.list.weather.utils.Codes

/**
 * Activity to display weather conditions for a particular location in list.
 * Demonstrated the use of Clean Architecture Design pattern using Use Case for this Activity.
 */
class WeatherListActivity : BaseWeatherFeatureActivity(), WeatherView, Injectable,
        WeatherAdapter.OnItemClickListener {

    private lateinit var presenter: WeatherPresenter
    private lateinit var getWeatherUseCase: GetWeatherListUseCase
    private lateinit var inflater: LayoutInflater
    private lateinit var currentLocationListener: CurrentLocationListener
    private lateinit var weatherAdapter: WeatherAdapter
    private var recyclerView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var loadingBar: ProgressBar? = null
    private var msgText: TextView? = null
    private var toolbarLayout: CollapsingToolbarLayout? = null
    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUI()
        setupPresenter()
        setRecyclerView()

        if (Utilities.checkPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            subscribeToLocationUpdate()
        } else {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        Codes.LOCATION_PERMISSION)
            }
        }
    }

    /**
     * Need to initialize UI elements as kotlin synthtic view extensions not supported for non-base feature module.
     * Also Data binding is not supported for non-base feature module, but according to some android blog-post these features
     * are supported in Android Studio 3.1.0 and above .... Need to test
     */
    private fun initUIElements() {
        rootView = findViewById(R.id.scrolling_view)
        loadingBar = rootView?.findViewById(R.id.loadingBar)
        toolbar = findViewById(R.id.toolbar)
        msgText = rootView?.findViewById(R.id.msgText)
        recyclerView = rootView?.findViewById(R.id.recyclerView)
        toolbarLayout = findViewById(R.id.toolbar_layout)
    }

    /**
     * Fetching location using {link @CurrentLocationListener}
     */
    private fun subscribeToLocationUpdate() {
        currentLocationListener.observe(this, Observer<Location> { location ->
            location?.let {
                Log.d("", "onChanged: location updated " + "${it.latitude} , ${it.longitude}")
                presenter.dataGetWeatherDetails(it)
            }
        })
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    private fun setupUI() {
        initUIElements()
        toolbar?.title = resources.getString(R.string.demo_name)
        toolbarLayout?.title = resources.getString(R.string.empty)
        setSupportActionBar(toolbar)
    }

    private fun setupPresenter() {
        presenter = WeatherPresenter(this, getWeatherUseCase)
    }

    private fun setRecyclerView() {
        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.layoutManager = LinearLayoutManager(this)
            weatherAdapter = WeatherAdapter(this, inflater)
            it.adapter = weatherAdapter
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_weather_main
    }

    override fun showProgressBar() {
        loadingBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        loadingBar?.visibility = View.GONE
    }

    override fun showErrorMessage(show: Boolean, errorMessage: String?) {
        msgText?.visibility = if (show) View.VISIBLE else View.GONE
        errorMessage?.let { msgText?.text = it }
    }

    override fun displayNetworkError() {
        msgText?.visibility = View.VISIBLE
        msgText?.text = resources.getString(R.string.no_network)
    }

    override fun showWeatherData(dataList: List<DailyWeatherDataModel>) {
        weatherAdapter.setData(dataList)
    }

    override fun showList(show: Boolean) {
        recyclerView?.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == Codes.LOCATION_PERMISSION) {
            subscribeToLocationUpdate()
        } else {
            showErrorMessage(true, resources.getString(R.string.permission_denied))
        }
    }

    /**
     * Click listeners for navigating to activities in other non-base feature modules.
     * For both full installable applications and instant apps this way of navigation using urls will work
     */
    override fun onRowClicked(dailyItemData: DailyWeatherDataModel?) {
        val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://avinash.weather.instantapp.com/detail/"))
        intent.`package` = this@WeatherListActivity.packageName
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        dailyItemData?.let {
            intent.putExtra(WeatherDetailsActivity.DATA_KEY, it)
        }
        startActivity(intent)
    }

    @Inject
    fun setUseCase(getWeatherUseCase: GetWeatherListUseCase) {
        this.getWeatherUseCase = getWeatherUseCase
    }

    @Inject
    fun setInflater(inflater: LayoutInflater) {
        this.inflater = inflater
    }

    @Inject
    fun setCurrentLocationListener(listener: CurrentLocationListener) {
        this.currentLocationListener = listener
    }
}