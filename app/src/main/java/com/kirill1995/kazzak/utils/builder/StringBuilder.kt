package com.kirill1995.kazzak.utils.builder

interface StringBuilder {
    fun buildCityWithCountryCodeValue(city: String, countryCode: String) =
        "$city,$countryCode"
}