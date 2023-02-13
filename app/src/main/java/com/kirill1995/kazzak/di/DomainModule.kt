package com.kirill1995.kazzak.di

import com.kirill1995.kazzak.domain.usesCases.geo.GetGeoDataUseCase
import com.kirill1995.kazzak.domain.usesCases.weather.GetThreeHourForecastFiveDaysDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetThreeHourForecastFiveDaysDataUseCase> {
        GetThreeHourForecastFiveDaysDataUseCase(weatherRepository = get())
    }

    factory<GetGeoDataUseCase> {
        GetGeoDataUseCase(geoRepository = get())
    }
}