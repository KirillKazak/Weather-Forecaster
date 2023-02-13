package com.kirill1995.kazzak.data.api

import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.ThreeHourForecastFiveDaysModel
import com.kirill1995.kazzak.utils.Constants.UNITS_METRIC
import com.kirill1995.kazzak.utils.Constants.WEATHER_API_KEY
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/forecast?appid=$WEATHER_API_KEY&units=$UNITS_METRIC")
    fun getThreeHourForecastFiveDaysData(
        @Query("q")
        cityWithCountryCode: String = "Moscow,RU"
    ): Single<ThreeHourForecastFiveDaysModel>
}