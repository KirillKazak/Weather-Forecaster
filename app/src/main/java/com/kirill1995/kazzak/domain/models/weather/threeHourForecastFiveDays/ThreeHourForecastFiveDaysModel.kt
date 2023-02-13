package com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays


import com.google.gson.annotations.SerializedName

data class ThreeHourForecastFiveDaysModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WaetherList>,
    val message: Int
)