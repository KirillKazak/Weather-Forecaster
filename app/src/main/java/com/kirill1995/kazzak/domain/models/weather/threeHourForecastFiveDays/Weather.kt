package com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays


import com.google.gson.annotations.SerializedName

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)