package com.kirill1995.kazzak.utils.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.databinding.TodayCustomViewBinding
import com.kirill1995.kazzak.databinding.WeekDayCustomViewBinding

class WeekDayCustomView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    private val vbWeekDay = WeekDayCustomViewBinding.inflate(
        LayoutInflater.from(context),
        this, false
    )

    init {
        addView(vbWeekDay.root)
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.WeekDayCustomView, 0, 0
        )

        vbWeekDay.apply {
            val weekDayDay = typedArray.getString(R.styleable.WeekDayCustomView_week_day_day)
            val weekDayDate = typedArray.getString(R.styleable.WeekDayCustomView_week_day_date)
            val weekDayImage = typedArray.getDrawable(R.styleable.WeekDayCustomView_week_day_image)
            val weekDayTemperature = typedArray.getString(R.styleable.WeekDayCustomView_week_day_temperature)

            tvDayWeekDay.text = weekDayDay
            tvDateWeekDay.text = weekDayDate
            ivWeatherWeekDay.background = weekDayImage
            tvTemperatureWeekDay.text = weekDayTemperature
        }
    }

    fun setDay(day: String) {
        vbWeekDay.tvDayWeekDay.text = day
    }

    fun setDate(date: String) {
        vbWeekDay.tvDateWeekDay.text = date
    }

    fun setImage(image: Int) {
        vbWeekDay.ivWeatherWeekDay.setBackgroundResource(image)
    }

    fun setImageFromApi(url: String) {
        Glide.with(vbWeekDay.ivWeatherWeekDay)
            .load(url)
            .into(vbWeekDay.ivWeatherWeekDay)
    }

    fun setTemperature(temperature: String) {
        vbWeekDay.tvTemperatureWeekDay.text = temperature
    }
}