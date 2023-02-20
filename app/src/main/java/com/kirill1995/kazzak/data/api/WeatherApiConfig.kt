package com.kirill1995.kazzak.data.api

import com.kirill1995.kazzak.utils.Constants.WEATHER_API_LINK
import com.kirill1995.kazzak.utils.builder.buildRetrofit

class WeatherApiConfig {

    val weatherApi: WeatherApi by lazy {
        buildRetrofit(WEATHER_API_LINK).create(WeatherApi::class.java)
    }
}