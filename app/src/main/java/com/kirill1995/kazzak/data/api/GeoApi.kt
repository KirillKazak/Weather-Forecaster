package com.kirill1995.kazzak.data.api

import com.kirill1995.kazzak.domain.models.geo.GeoModel
import com.kirill1995.kazzak.utils.Constants.GEO_API_KEY
import io.reactivex.Single
import retrofit2.http.GET

interface GeoApi {
    @GET("json/?key=$GEO_API_KEY")
    fun getGeoData(): Single<GeoModel>
}