package com.kirill1995.kazzak.domain.usesCases.geo

import com.kirill1995.kazzak.domain.models.geo.GeoModel
import com.kirill1995.kazzak.domain.repository.GeoRepository
import io.reactivex.Single

class GetGeoDataUseCase(private val geoRepository: GeoRepository) {

    fun getGeoData() = geoRepository.getGeoData()
}