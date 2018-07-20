package com.avinash.weatherapp.model

class WeatherData(builder: Builder) {

    var daily: DailyMain?

    class Builder {
        var daily: DailyMain? = null

        fun daily(daily: DailyMain): Builder {
            this.daily = daily
            return this
        }

        fun build(): WeatherData {
            return WeatherData(this)
        }
    }

    init {
        daily = builder.daily
    }
}