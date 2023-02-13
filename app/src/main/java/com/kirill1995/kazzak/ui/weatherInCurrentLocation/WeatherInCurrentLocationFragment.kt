package com.kirill1995.kazzak.ui.weatherInCurrentLocation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirill1995.kazzak.databinding.FragmentWeatherInCurrentLocationBinding
import com.kirill1995.kazzak.utils.builder.StringBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherInCurrentLocationFragment : Fragment(), StringBuilder {
    private val vm: WeatherInCurrentLocationViewModel by viewModel()
    private lateinit var vbWeatherInCurrentLocation: FragmentWeatherInCurrentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vbWeatherInCurrentLocation =
            FragmentWeatherInCurrentLocationBinding.inflate(inflater, container, false)
        return vbWeatherInCurrentLocation.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getGeoDataByApi()
        startObserveGeoLiveData()
        startObserveThreeHourForecastFiveDaysLiveData()
    }

    private fun getGeoDataByApi() {
        vm.getGeoData()
    }

    private fun getThreeHourForecastFiveDaysDataByApi(city: String, countryCode: String) {
        vm.getThreeHourForecastFiveDaysData(buildCityWithCountryCodeValue(city, countryCode))
    }

    private fun startObserveGeoLiveData() {
        vm.geoLiveData.observe(viewLifecycleOwner) { geoData ->
            getThreeHourForecastFiveDaysDataByApi(geoData.city, geoData.countryCode)
        }
    }

    private fun startObserveThreeHourForecastFiveDaysLiveData() {
        vm.threeHourForecastFiveDaysLiveData.observe(viewLifecycleOwner) { data ->
            Log.d("threeHourForecastFiveDaysDataLiveData", "In ${data.city.name} ${data.list[0].weather[0].description}")
        }
    }
}