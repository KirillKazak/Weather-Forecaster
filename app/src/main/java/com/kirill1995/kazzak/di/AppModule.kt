package com.kirill1995.kazzak.di

import com.kirill1995.kazzak.ui.weatherInCurrentLocation.WeatherInCurrentLocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<WeatherInCurrentLocationViewModel>{
        WeatherInCurrentLocationViewModel(
            getThreeHourForecastFiveDaysDataUseCase = get(),
            getGeoDataUseCase = get()
        )
    }
}