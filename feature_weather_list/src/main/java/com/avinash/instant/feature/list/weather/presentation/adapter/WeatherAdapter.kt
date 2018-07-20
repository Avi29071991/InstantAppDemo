package com.avinash.instant.feature.list.weather.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.avinash.instant.feature.list.weather.R
import com.avinash.instantapp.base.model.DailyWeatherDataModel
import com.avinash.instant.feature.list.weather.viewmodel.WeatherBindings

/**
 * Adapter class used to display weather details in list
 */
class WeatherAdapter constructor(itemClickListener: WeatherAdapter.OnItemClickListener, layoutInflater: LayoutInflater) : RecyclerView.Adapter<WeatherAdapter.DailyViewHolder>() {

    private var listener: WeatherAdapter.OnItemClickListener = itemClickListener
    private var dailyList = ArrayList<DailyWeatherDataModel>()
    private var inflater: LayoutInflater = layoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val rootView = inflater.inflate(R.layout.weather_row, parent, false)
        return DailyViewHolder(rootView, listener)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val data: DailyWeatherDataModel? = getItem(position)
        data?.let {
            WeatherBindings.setWeatherIcon(holder.weatherIcon, it.getIcon().let { it }!!)
            WeatherBindings.setTemparature(holder.valMin, it.getMinTemperature().let { it })
            WeatherBindings.setTemparature(holder.valMax, it.getMaxTemperature().let { it })
            WeatherBindings.setText(holder.tvDay, it.getDay().let { it })
            WeatherBindings.setText(holder.tvDate, it.getDate().let { it })
            WeatherBindings.setText(holder.textCon, it.getSummary().let { it }!!)
        }
    }

    override fun getItemCount(): Int {
        return dailyList.size
    }

    fun setData(dataList: List<DailyWeatherDataModel>) {
        dailyList.clear()
        for (data in dataList) {
            dailyList.add(data)
        }
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onRowClicked(dailyItemData: DailyWeatherDataModel?)
    }


    inner class DailyViewHolder internal constructor(v: View, listener: WeatherAdapter.OnItemClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var itemListener: WeatherAdapter.OnItemClickListener = listener
        var view: View = v
        var container: View? = view.findViewById(R.id.container)
        var weatherIcon: ImageView? = view.findViewById(R.id.weather_icon)
        var tvDay: TextView? = view.findViewById(R.id.tvDay)
        var tvDate: TextView? = view.findViewById(R.id.tvDate)
        var valMin: TextView? = view.findViewById(R.id.valMin)
        var valMax: TextView? = view.findViewById(R.id.valMax)
        var textCon: TextView? = view.findViewById(R.id.textCon)

        init {
            container?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            itemListener.onRowClicked(getItem(adapterPosition))
        }
    }

    fun getItem(position: Int): DailyWeatherDataModel? {
        return if (!dailyList.isEmpty()) dailyList[position] else null
    }
}