package com.kirill1995.kazzak.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.WaetherList
import com.kirill1995.kazzak.utils.Constants
import com.kirill1995.kazzak.utils.DateConverter

class WeekDayAdapter (private val context: Context):
    RecyclerView.Adapter<WeekDayAdapter.WeekdayViewHolder>(), DateConverter {

    var weatherList = listOf<WaetherList>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekdayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.week_day_custom_view, parent, false)
        return WeekdayViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeekdayViewHolder, position: Int) {
        val itemWeatherToday= weatherList[position]

        holder.tvDayWeekDay.text = convertUnixToWeekday(itemWeatherToday.dt)
        holder.tvDateWeekDay.text = "${convertCurrentDate(itemWeatherToday.dtTxt)[3]}/${convertCurrentDate(itemWeatherToday.dtTxt)[1]}"
        Glide.with(holder.ivWeatherWeekDay)
            .load(Constants.WEATHER_API_IMAGE_LINK + itemWeatherToday.weather[0].icon + "@2x.png")
            .into(holder.ivWeatherWeekDay)
        holder.tvTemperatureWeekDay.text= "${itemWeatherToday.main.tempMin.toInt()}${context.getString(R.string.degree)}/${itemWeatherToday.main.tempMax.toInt()}${context.getString(R.string.degree)}"
    }

    override fun getItemCount(): Int = weatherList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class WeekdayViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var tvDayWeekDay: TextView = view.findViewById(R.id.tv_day_week_day)
        val tvDateWeekDay: TextView = view.findViewById(R.id.tv_date_week_day)
        val ivWeatherWeekDay: ImageView = view.findViewById(R.id.iv_weather_week_day)
        val tvTemperatureWeekDay: TextView = view.findViewById(R.id.tv_temperature_week_day)
    }
}