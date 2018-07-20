package com.avinash.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DailyData {

    @SerializedName("time")
    @Expose
    private var time: Long = 0
    @SerializedName("summary")
    @Expose
    private var summary: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null
    @SerializedName("sunriseTime")
    @Expose
    private var sunriseTime: Int = 0
    @SerializedName("sunsetTime")
    @Expose
    private var sunsetTime: Int = 0
    @SerializedName("moonPhase")
    @Expose
    private var moonPhase: Double = 0.toDouble()
    @SerializedName("precipIntensity")
    @Expose
    private var precipIntensity: Double = 0.toDouble()
    @SerializedName("precipIntensityMax")
    @Expose
    private var precipIntensityMax: Double = 0.toDouble()
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private var precipIntensityMaxTime: Int = 0
    @SerializedName("precipProbability")
    @Expose
    private var precipProbability: Double = 0.toDouble()
    @SerializedName("precipType")
    @Expose
    private var precipType: String? = null
    @SerializedName("temperatureMin")
    @Expose
    private var temperatureMin: Double = 0.toDouble()
    @SerializedName("temperatureMinTime")
    @Expose
    private var temperatureMinTime: Int = 0
    @SerializedName("temperatureMax")
    @Expose
    private var temperatureMax: Double = 0.toDouble()
    @SerializedName("temperatureMaxTime")
    @Expose
    private var temperatureMaxTime: Int = 0
    @SerializedName("apparentTemperatureMin")
    @Expose
    private var apparentTemperatureMin: Double = 0.toDouble()
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private var apparentTemperatureMinTime: Int = 0
    @SerializedName("apparentTemperatureMax")
    @Expose
    private var apparentTemperatureMax: Double = 0.toDouble()
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private var apparentTemperatureMaxTime: Int = 0
    @SerializedName("dewPoint")
    @Expose
    private var dewPoint: Double = 0.toDouble()
    @SerializedName("humidity")
    @Expose
    private var humidity: Double = 0.toDouble()
    @SerializedName("windSpeed")
    @Expose
    private var windSpeed: Double = 0.toDouble()
    @SerializedName("windBearing")
    @Expose
    private var windBearing: Int = 0
    @SerializedName("visibility")
    @Expose
    private var visibility: Double = 0.toDouble()
    @SerializedName("cloudCover")
    @Expose
    private var cloudCover: Double = 0.toDouble()
    @SerializedName("pressure")
    @Expose
    private var pressure: Double = 0.toDouble()
    @SerializedName("ozone")
    @Expose
    private var ozone: Double = 0.toDouble()

    /**
     * @return The time
     */
    fun getTime(): Long {
        return time
    }

    /**
     * @param time The time
     */
    fun setTime(time: Long) {
        this.time = time
    }

    /**
     * @return The summary
     */
    fun getSummary(): String? {
        return summary
    }

    /**
     * @param summary The summary
     */
    fun setSummary(summary: String) {
        this.summary = summary
    }

    /**
     * @return The icon
     */
    fun getIcon(): String? {
        return icon
    }

    /**
     * @param icon The icon
     */
    fun setIcon(icon: String) {
        this.icon = icon
    }

    /**
     * @return The sunriseTime
     */
    fun getSunriseTime(): Int {
        return sunriseTime
    }

    /**
     * @param sunriseTime The sunriseTime
     */
    fun setSunriseTime(sunriseTime: Int) {
        this.sunriseTime = sunriseTime
    }

    /**
     * @return The sunsetTime
     */
    fun getSunsetTime(): Int {
        return sunsetTime
    }

    /**
     * @param sunsetTime The sunsetTime
     */
    fun setSunsetTime(sunsetTime: Int) {
        this.sunsetTime = sunsetTime
    }

    /**
     * @return The moonPhase
     */
    fun getMoonPhase(): Double {
        return moonPhase
    }

    /**
     * @param moonPhase The moonPhase
     */
    fun setMoonPhase(moonPhase: Double) {
        this.moonPhase = moonPhase
    }

    /**
     * @return The precipIntensity
     */
    fun getPrecipIntensity(): Double {
        return precipIntensity
    }

    /**
     * @param precipIntensity The precipIntensity
     */
    fun setPrecipIntensity(precipIntensity: Double) {
        this.precipIntensity = precipIntensity
    }

    /**
     * @return The precipIntensityMax
     */
    fun getPrecipIntensityMax(): Double {
        return precipIntensityMax
    }

    /**
     * @param precipIntensityMax The precipIntensityMax
     */
    fun setPrecipIntensityMax(precipIntensityMax: Double) {
        this.precipIntensityMax = precipIntensityMax
    }

    /**
     * @return The precipIntensityMaxTime
     */
    fun getPrecipIntensityMaxTime(): Int {
        return precipIntensityMaxTime
    }

    /**
     * @param precipIntensityMaxTime The precipIntensityMaxTime
     */
    fun setPrecipIntensityMaxTime(precipIntensityMaxTime: Int) {
        this.precipIntensityMaxTime = precipIntensityMaxTime
    }

    /**
     * @return The precipProbability
     */
    fun getPrecipProbability(): Double {
        return precipProbability
    }

    /**
     * @param precipProbability The precipProbability
     */
    fun setPrecipProbability(precipProbability: Double) {
        this.precipProbability = precipProbability
    }

    /**
     * @return The precipType
     */
    fun getPrecipType(): String? {
        return precipType
    }

    /**
     * @param precipType The precipType
     */
    fun setPrecipType(precipType: String) {
        this.precipType = precipType
    }

    /**
     * @return The temperatureMin
     */
    fun getTemperatureMin(): Double {
        return temperatureMin
    }

    /**
     * @param temperatureMin The temperatureMin
     */
    fun setTemperatureMin(temperatureMin: Double) {
        this.temperatureMin = temperatureMin
    }

    /**
     * @return The temperatureMinTime
     */
    fun getTemperatureMinTime(): Int {
        return temperatureMinTime
    }

    /**
     * @param temperatureMinTime The temperatureMinTime
     */
    fun setTemperatureMinTime(temperatureMinTime: Int) {
        this.temperatureMinTime = temperatureMinTime
    }

    /**
     * @return The temperatureMax
     */
    fun getTemperatureMax(): Double {
        return temperatureMax
    }

    /**
     * @param temperatureMax The temperatureMax
     */
    fun setTemperatureMax(temperatureMax: Double) {
        this.temperatureMax = temperatureMax
    }

    /**
     * @return The temperatureMaxTime
     */
    fun getTemperatureMaxTime(): Int {
        return temperatureMaxTime
    }

    /**
     * @param temperatureMaxTime The temperatureMaxTime
     */
    fun setTemperatureMaxTime(temperatureMaxTime: Int) {
        this.temperatureMaxTime = temperatureMaxTime
    }

    /**
     * @return The apparentTemperatureMin
     */
    fun getApparentTemperatureMin(): Double {
        return apparentTemperatureMin
    }

    /**
     * @param apparentTemperatureMin The apparentTemperatureMin
     */
    fun setApparentTemperatureMin(apparentTemperatureMin: Double) {
        this.apparentTemperatureMin = apparentTemperatureMin
    }

    /**
     * @return The apparentTemperatureMinTime
     */
    fun getApparentTemperatureMinTime(): Int {
        return apparentTemperatureMinTime
    }

    /**
     * @param apparentTemperatureMinTime The apparentTemperatureMinTime
     */
    fun setApparentTemperatureMinTime(apparentTemperatureMinTime: Int) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime
    }

    /**
     * @return The apparentTemperatureMax
     */
    fun getApparentTemperatureMax(): Double {
        return apparentTemperatureMax
    }

    /**
     * @param apparentTemperatureMax The apparentTemperatureMax
     */
    fun setApparentTemperatureMax(apparentTemperatureMax: Double) {
        this.apparentTemperatureMax = apparentTemperatureMax
    }

    /**
     * @return The apparentTemperatureMaxTime
     */
    fun getApparentTemperatureMaxTime(): Int {
        return apparentTemperatureMaxTime
    }

    /**
     * @param apparentTemperatureMaxTime The apparentTemperatureMaxTime
     */
    fun setApparentTemperatureMaxTime(apparentTemperatureMaxTime: Int) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime
    }

    /**
     * @return The dewPoint
     */
    fun getDewPoint(): Double {
        return dewPoint
    }

    /**
     * @param dewPoint The dewPoint
     */
    fun setDewPoint(dewPoint: Double) {
        this.dewPoint = dewPoint
    }

    /**
     * @return The humidity
     */
    fun getHumidity(): Double {
        return humidity
    }

    /**
     * @param humidity The humidity
     */
    fun setHumidity(humidity: Double) {
        this.humidity = humidity
    }

    /**
     * @return The windSpeed
     */
    fun getWindSpeed(): Double {
        return windSpeed
    }

    /**
     * @param windSpeed The windSpeed
     */
    fun setWindSpeed(windSpeed: Double) {
        this.windSpeed = windSpeed
    }

    /**
     * @return The windBearing
     */
    fun getWindBearing(): Int {
        return windBearing
    }

    /**
     * @param windBearing The windBearing
     */
    fun setWindBearing(windBearing: Int) {
        this.windBearing = windBearing
    }

    /**
     * @return The visibility
     */
    fun getVisibility(): Double {
        return visibility
    }

    /**
     * @param visibility The visibility
     */
    fun setVisibility(visibility: Double) {
        this.visibility = visibility
    }

    /**
     * @return The cloudCover
     */
    fun getCloudCover(): Double {
        return cloudCover
    }

    /**
     * @param cloudCover The cloudCover
     */
    fun setCloudCover(cloudCover: Double) {
        this.cloudCover = cloudCover
    }

    /**
     * @return The pressure
     */
    fun getPressure(): Double {
        return pressure
    }

    /**
     * @param pressure The pressure
     */
    fun setPressure(pressure: Double) {
        this.pressure = pressure
    }

    /**
     * @return The ozone
     */
    fun getOzone(): Double {
        return ozone
    }

    /**
     * @param ozone The ozone
     */
    fun setOzone(ozone: Double) {
        this.ozone = ozone
    }
}