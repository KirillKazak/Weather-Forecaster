package com.kirill1995.kazzak.di

import com.kirill1995.kazzak.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HomeViewModel>{
        HomeViewModel(
            getThreeHourForecastFiveDaysDataUseCase = get(),
            getGeoDataUseCase = get()
        )
    }
}