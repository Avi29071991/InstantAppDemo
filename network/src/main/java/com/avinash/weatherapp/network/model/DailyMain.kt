package com.avinash.weatherapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


class DailyMain {
    @SerializedName("summary")
    @Expose
    private var summary: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null
    @SerializedName("data")
    @Expose
    private var data: List<DailyData> = ArrayList()

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
     * @return The data
     */
    fun getData(): List<DailyData> {
        return data
    }

    /**
     * @param data The data
     */
    fun setData(data: List<DailyData>) {
        this.data = data
    }
}