package com.avinash.weatherapp.model

import java.io.Serializable
import java.util.*


class DailyMain(builder: Builder) : Serializable {

    var summary: String
    var icon: String
    var data: List<Daily>

    class Builder {

        var summary: String = ""
        var icon: String = ""
        var data: List<Daily> = ArrayList()

        fun summary(summary: String): Builder {
            this.summary = summary
            return this
        }

        fun icon(icon: String): Builder {
            this.icon = icon
            return this
        }

        fun data(data: List<Daily>): Builder {
            this.data = data
            return this
        }

        fun build(): DailyMain {
            return DailyMain(this)
        }
    }

    init {
        summary = builder.summary
        icon = builder.icon
        data = builder.data
    }
}