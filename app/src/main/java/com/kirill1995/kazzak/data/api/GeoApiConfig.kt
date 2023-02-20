package com.kirill1995.kazzak.data.api

import com.kirill1995.kazzak.utils.Constants.GEO_API_LINK
import com.kirill1995.kazzak.utils.builder.buildRetrofit

class GeoApiConfig {

    val geoApi: GeoApi by lazy {
        buildRetrofit(GEO_API_LINK).create(GeoApi::class.java)
    }
}