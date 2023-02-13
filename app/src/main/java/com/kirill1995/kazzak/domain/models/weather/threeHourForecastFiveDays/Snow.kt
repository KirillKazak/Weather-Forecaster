package com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val h: Double
)