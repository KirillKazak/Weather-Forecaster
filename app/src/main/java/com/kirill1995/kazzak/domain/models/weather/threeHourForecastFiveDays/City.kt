package com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays


import com.google.gson.annotations.SerializedName

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)