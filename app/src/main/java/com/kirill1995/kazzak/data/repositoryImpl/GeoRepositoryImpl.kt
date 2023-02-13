package com.kirill1995.kazzak.data.repositoryImpl

import com.kirill1995.kazzak.data.api.GeoApiConfig
import com.kirill1995.kazzak.domain.models.geo.GeoModel
import com.kirill1995.kazzak.domain.repository.GeoRepository
import io.reactivex.Single

class GeoRepositoryImpl: GeoRepository {

    override fun getGeoData() =
        GeoApiConfig().geoApi.getGeoData()
}