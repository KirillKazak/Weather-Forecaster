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

class TodayAdapter (private val context: Context):
    RecyclerView.Adapter<TodayAdapter.TodayViewHolder>(), DateConverter {

    var weatherList = listOf<WaetherList>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.today_custom_view, parent, false)
        return TodayViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        val itemWeatherToday= weatherList[position]

        holder.tvTimeToday.text = "${convertCurrentDate(itemWeatherToday.dtTxt)[4]}:${convertCurrentDate(itemWeatherToday.dtTxt)[5]}"
        Glide.with(holder.ivWeatherToday)
            .load(Constants.WEATHER_API_IMAGE_LINK + itemWeatherToday.weather[0].icon + "@2x.png")
            .into(holder.ivWeatherToday)
        holder.tvTemperatureToday.text = itemWeatherToday.main.temp.toInt().toString() + context.getString(R.string.сelsius)
    }

    override fun getItemCount(): Int = weatherList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class TodayViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val tvTimeToday: TextView = view.findViewById(R.id.tv_time_today)
        val ivWeatherToday: ImageView = view.findViewById(R.id.iv_weather_today)
        val tvTemperatureToday: TextView = view.findViewById(R.id.tv_temperature_today)
    }
}