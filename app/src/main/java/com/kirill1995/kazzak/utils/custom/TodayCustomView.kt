package com.kirill1995.kazzak.utils.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.databinding.TodayCustomViewBinding

class TodayCustomView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    private val vbToday = TodayCustomViewBinding.inflate(
        LayoutInflater.from(context),
        this, false
    )

    init {
        addView(vbToday.root)
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TodayCustomView, 0, 0
        )

        vbToday.apply {
            val todayTime = typedArray.getString(R.styleable.TodayCustomView_today_time)
            val todayImage = typedArray.getDrawable(R.styleable.TodayCustomView_today_image)
            val todayTemperature = typedArray.getString(R.styleable.TodayCustomView_today_temperature)

            tvTimeToday.text = todayTime
            ivWeatherToday.background = todayImage
            tvTemperatureToday.text = todayTemperature
        }
    }

    fun setTime(time: String) {
        vbToday.tvTimeToday.text = time
    }

    fun setImage(image: Int) {
        vbToday.ivWeatherToday.setBackgroundResource(image)
    }

    fun setTemperature(temperature: String) {
        vbToday.tvTemperatureToday.text = temperature
    }

    fun setImageFromApi(url: String) {
        Glide.with(vbToday.ivWeatherToday)
            .load(url)
            .into(vbToday.ivWeatherToday)
    }
}