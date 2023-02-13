package com.kirill1995.kazzak.domain.repository

import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.ThreeHourForecastFiveDaysModel
import io.reactivex.Single

interface WeatherRepository {
    fun getThreeHourForecastFiveDaysData(cityWithCountryCode: String): Single<ThreeHourForecastFiveDaysModel>
}