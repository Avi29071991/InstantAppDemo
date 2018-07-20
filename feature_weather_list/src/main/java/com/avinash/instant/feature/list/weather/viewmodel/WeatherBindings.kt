package com.avinash.instant.feature.list.weather.viewmodel

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.avinash.instant.feature.list.weather.R
import com.avinash.instant.feature.list.weather.utils.WeatherConstants
import com.avinash.instantapp.base.utils.Utilities

/**
 * Object for setting values for different views
 */
object WeatherBindings {
    /**
     * Creates a new tag which can be used in the xml file for displaying the icon according to the specified weather condition.

     * @param iconType  the type of icon for weather condition which needs to be displayed in the layout.
     * *
     * @param imageView the ImageView in which image needs to be displayed.
     */


    @BindingAdapter("app:weatherIcon")
    @JvmStatic fun setWeatherIcon(imageView: ImageView?, iconType: String) {
        if (imageView != null && Utilities.isNotEmpty(iconType)) {
            when (iconType) {
                WeatherConstants.RAIN, WeatherConstants.HAIL, WeatherConstants.THUNDERSTORM ->

                    imageView.setImageResource(R.drawable.w_09n)

                WeatherConstants.CLEAR_DAY, WeatherConstants.CLEAR_NIGHT, WeatherConstants.SNOW, WeatherConstants.WIND, WeatherConstants.SLEET ->

                    imageView.setImageResource(R.drawable.w_01d)

                WeatherConstants.CLOUDY, WeatherConstants.FOG, WeatherConstants.PARTLY_CLOUDY_DAY, WeatherConstants.PARTLY_CLOUDY_NIGHT ->

                    imageView.setImageResource(R.drawable.w_03d)
            }
        }
    }

    /**
     * Creates a new tag which can be used in the xml
     * file for displaying the temperature in the below specified format

     * @param temp     the temperature value which needs to be converted and displayed in the layout.
     * *
     * @param textview the TextView in which temperature needs oto be displayed.
     */

    @BindingAdapter("app:temperature")
    @JvmStatic fun setTemparature(textview: TextView?, temp: String) {
        if (textview != null) {
            textview.text = textview.context.getString(R.string.degcelcius, temp)
        }
    }

    /**
     * Creates a new tag which can be used in the xml file for displaying the text.

     * @param text     the text value which needs to be displayed in the layout.
     * *
     * @param textView the TextView in which text needs to be displayed.
     */
    @BindingAdapter("app:text")
    @JvmStatic fun setText(textView: TextView?, text: String) {
        if (textView != null && Utilities.isNotEmpty(text)) {
            if (Utilities.isNotEmpty(text)) {
                textView.text = text
            } else {
                textView.setText(R.string.not_available)
            }
        }
    }
}