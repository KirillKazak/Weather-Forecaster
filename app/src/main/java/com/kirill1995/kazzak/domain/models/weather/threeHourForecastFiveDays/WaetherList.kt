package com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays


import com.google.gson.annotations.SerializedName

data class WaetherList(
    val clouds: Clouds,
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    val main: Main,
    val pop: Double,
    val snow: Snow,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)