package com.kirill1995.kazzak.domain.usesCases.weather

import com.kirill1995.kazzak.domain.repository.WeatherRepository

class GetThreeHourForecastFiveDaysDataUseCase(private val weatherRepository: WeatherRepository) {

    fun getThreeHourForecastFiveDaysData(cityWithCountryCode: String) =
        weatherRepository.getThreeHourForecastFiveDaysData(cityWithCountryCode)
}