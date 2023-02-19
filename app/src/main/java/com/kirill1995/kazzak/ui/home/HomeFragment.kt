package com.kirill1995.kazzak.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.databinding.FragmentHomeBinding
import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.ThreeHourForecastFiveDaysModel
import com.kirill1995.kazzak.utils.Constants.WEATHER_API_IMAGE_LINK
import com.kirill1995.kazzak.utils.DateConverter
import com.kirill1995.kazzak.utils.builder.StringBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

//TODO("Create BaseFragment")
class HomeFragment : Fragment(), StringBuilder, DateConverter {
    private val vm: HomeViewModel by viewModel()
    private lateinit var vbHome: FragmentHomeBinding
    private val homeAdapter by lazy { TodayAdapter(requireContext()) }
    private val weekdayAdapter by lazy { WeekDayAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vbHome =
            FragmentHomeBinding.inflate(inflater, container, false)
        return vbHome.root
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

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun startObserveThreeHourForecastFiveDaysLiveData() {
        vm.threeHourForecastFiveDaysLiveData.observe(viewLifecycleOwner) { data ->
            setDataToMainViews(data)
            setDataToCurrentViews(data)
            setDataToTodayViews(data)
            setDataToSunTimeViews(data)
            setDataToWeekdaysViews(data)
            setDataToSummaryViews(data)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDataToMainViews(data: ThreeHourForecastFiveDaysModel) {
        with(vbHome){
            Glide.with(ivMainWeatherHome)
                .load(WEATHER_API_IMAGE_LINK + data.list[0].weather[0].icon + "@2x.png")
                .into(ivMainWeatherHome)
            tvMainTemperatureHome.text = data.list[0].main.temp.toInt().toString() +
                    getString(R.string.сelsius)
            tvCityNameHome.text = "${data.city.name}, ${data.city.country}"
            tvDescriptionHome.text = data.list[0].weather[0].description
            tvFeelsLikeHome.text = " " + getString(R.string.feels_like) +
                    data.list[0].main.feelsLike.toInt().toString() +
                    getString(R.string.сelsius)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDataToCurrentViews(data: ThreeHourForecastFiveDaysModel) {
        with(vbHome){
            tvCloudCurrentHome.text = data.list[0].clouds.all.toString() +
                    getString(R.string.percent)
            tvDropCurrentHome.text = data.list[0].main.humidity.toString() +
                    getString(R.string.percent)
            tvWindCurrentHome.text = data.list[0].wind.speed.toString() +
                    getString(R.string.meter_sec)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDataToTodayViews(data: ThreeHourForecastFiveDaysModel) {
        //TODO("Change to RecyclerView")
        with(vbHome){
            tvDateHome.text =
                "${convertCurrentDate(data.list[0].dtTxt)[2]}, ${convertCurrentDate(data.list[0].dtTxt)[3]}"

            homeAdapter.weatherList = listOf(data.list[0], data.list[1], data.list[2], data.list[3], data.list[4], data.list[5], data.list[6], data.list[7])
            recyclerViewTodayHome.adapter = homeAdapter
        }
    }

    private fun setDataToSunTimeViews(data: ThreeHourForecastFiveDaysModel) {
        with(vbHome){
            tvTimeSunRiseHome.text = convertUnixToTime(data.city.sunrise)
            tvTimeSunSetHome.text = convertUnixToTime(data.city.sunset)
        }
    }

    private fun setDataToWeekdaysViews(data: ThreeHourForecastFiveDaysModel) {
        with(vbHome){

            weekdayAdapter.weatherList = listOf(data.list[0], data.list[7], data.list[15], data.list[23], data.list[31])
            recyclerViewWeekdayHome.adapter = weekdayAdapter
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDataToSummaryViews(data: ThreeHourForecastFiveDaysModel) {
        with(vbHome){
            tvTemperatureSummaryHome.text = "${data.list[0].main.tempMin.toInt()}${getString(R.string.degree)}/${data.list[0].main.tempMax.toInt()}${getString(R.string.degree)}"
            tvCloudSummaryHome.text = "${data.list[0].clouds.all}${getString(R.string.percent)}"
            tvWindSummaryHome.text = "${data.list[0].wind.speed}${getString(R.string.meter_sec)}"
            tvSunRiseSummaryHome.text = convertUnixToTime(data.city.sunrise)
            tvSunSetSummaryHome.text = convertUnixToTime(data.city.sunset)
            tvHumiditySummaryHome.text = "${data.list[0].main.humidity}${getString(R.string.percent)}"
        }
    }
}