package com.kirill1995.kazzak.domain.repository

import com.kirill1995.kazzak.domain.models.geo.GeoModel
import io.reactivex.Single

interface GeoRepository {
    fun getGeoData(): Single<GeoModel>
}