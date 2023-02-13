package com.kirill1995.kazzak.domain.models.geo

import com.google.gson.annotations.SerializedName

data class GeoModel (
    val city: String,
    val country: String,
    val countryCode : String
)