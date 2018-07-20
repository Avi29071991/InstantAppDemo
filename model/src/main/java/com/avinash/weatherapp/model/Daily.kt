package com.avinash.weatherapp.model

import java.io.Serializable

class Daily(builder: Builder) : Serializable {

    var time: Long
    var summary: String?
    var icon: String?
    var sunriseTime: Int
    var sunsetTime: Int
    var temperatureMin: Double
    var temperatureMinTime: Int
    var temperatureMax: Double
    var temperatureMaxTime: Int
    var dewPoint: Double
    var humidity: Double
    var windSpeed: Double
    var pressure: Double
    var ozone: Double

    class Builder {
        var time: Long = 0
        var summary: String? = null
        var icon: String? = null
        var sunriseTime: Int = 0
        var sunsetTime: Int = 0
        var temperatureMin: Double = 0.0
        var temperatureMinTime: Int = 0
        var temperatureMax: Double = 0.0
        var temperatureMaxTime: Int = 0
        var dewPoint: Double = 0.0
        var humidity: Double = 0.0
        var windSpeed: Double = 0.0
        var pressure: Double = 0.0
        var ozone: Double = 0.0

        fun time(time: Long): Builder {
            this.time = time
            return this
        }

        fun summary(summary: String): Builder {
            this.summary = summary
            return this
        }

        fun icon(icon: String): Builder {
            this.icon = icon
            return this
        }

        fun sunriseTime(sunriseTime: Int): Builder {
            this.sunriseTime = sunriseTime
            return this
        }

        fun sunsetTime(sunsetTime: Int): Builder {
            this.sunsetTime = sunsetTime
            return this
        }

        fun temperatureMin(temperatureMin: Double): Builder {
            this.temperatureMin = temperatureMin
            return this
        }

        fun temperatureMinTime(temperatureMinTime: Int): Builder {
            this.temperatureMinTime = temperatureMinTime
            return this
        }

        fun dewPoint(dewPoint: Double): Builder {
            this.dewPoint = dewPoint
            return this
        }

        fun humidity(humidity: Double): Builder {
            this.humidity = humidity
            return this
        }

        fun windSpeed(windSpeed: Double): Builder {
            this.windSpeed = windSpeed
            return this
        }

        fun pressure(pressure: Double): Builder {
            this.pressure = pressure
            return this
        }

        fun ozone(ozone: Double): Builder {
            this.ozone = ozone
            return this
        }

        fun temperatureMax(temperatureMax: Double): Builder {
            this.temperatureMax = temperatureMax
            return this
        }

        fun temperatureMaxTime(temperatureMaxTime: Int): Builder {
            this.temperatureMaxTime = temperatureMaxTime
            return this
        }

        fun build(): Daily {
            return Daily(this)
        }
    }

    init {
        time = builder.time
        summary = builder.summary
        icon = builder.icon
        sunriseTime = builder.sunriseTime
        sunsetTime = builder.sunsetTime
        temperatureMin = builder.temperatureMin
        temperatureMinTime = builder.temperatureMinTime
        temperatureMax = builder.temperatureMax
        temperatureMaxTime = builder.temperatureMaxTime
        dewPoint = builder.dewPoint
        humidity = builder.humidity
        windSpeed = builder.windSpeed
        pressure = builder.pressure
        ozone = builder.ozone
    }
}