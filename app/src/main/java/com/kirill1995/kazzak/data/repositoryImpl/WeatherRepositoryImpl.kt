package com.kirill1995.kazzak.data.repositoryImpl

import com.kirill1995.kazzak.data.api.WeatherApiConfig
import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.ThreeHourForecastFiveDaysModel
import com.kirill1995.kazzak.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl: WeatherRepository {

    override fun getThreeHourForecastFiveDaysData(cityWithCountryCode: String) =
        WeatherApiConfig().weatherApi.getThreeHourForecastFiveDaysData(cityWithCountryCode)

}