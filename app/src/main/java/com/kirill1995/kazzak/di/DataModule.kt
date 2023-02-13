package com.kirill1995.kazzak.di

import com.kirill1995.kazzak.data.repositoryImpl.GeoRepositoryImpl
import com.kirill1995.kazzak.data.repositoryImpl.WeatherRepositoryImpl
import com.kirill1995.kazzak.domain.repository.GeoRepository
import com.kirill1995.kazzak.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<WeatherRepository> {
        WeatherRepositoryImpl()
    }

    single<GeoRepository> {
        GeoRepositoryImpl()
    }

}