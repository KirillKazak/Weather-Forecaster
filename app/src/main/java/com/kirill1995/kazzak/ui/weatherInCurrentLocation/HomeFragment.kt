package com.kirill1995.kazzak.ui.weatherInCurrentLocation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.databinding.FragmentHomeBinding
import com.kirill1995.kazzak.utils.Constants.MILLISECONDS_FACTOR
import com.kirill1995.kazzak.utils.builder.StringBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment(), StringBuilder {
    private val vm: HomeViewModel by viewModel()
    private lateinit var vbHome: FragmentHomeBinding

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
            Log.d("threeHourForecastFiveDaysDataLiveData", "In ${data.city.name} ${data.list.size}")
            with(vbHome) {

                Glide.with(this@HomeFragment)
                    .load("http://openweathermap.org/img/wn/"
                            + data.list[0].weather[0].icon + "@2x.png")
                    .into(ivMainWeatherHome)
                tvMainTemperatureHome.text = data.list[0].main.temp.toInt().toString() +
                        getString(R.string.сelsius)
                tvCityNameHome.text = "${data.city.name}, ${data.city.country}"
                tvDescriptionHome.text = data.list[0].weather[0].description
                tvFeelsLikeHome.text = getString(R.string.feels_like) +
                        data.list[0].main.feelsLike.toInt().toString() +
                        getString(R.string.сelsius)

                tvCloudCurrentHome.text = data.list[0].clouds.all.toString() +
                        getString(R.string.percent)
                tvDropCurrentHome.text = data.list[0].main.humidity.toString() +
                        getString(R.string.percent)
                tvWindCurrentHome.text = data.list[0].wind.speed.toString() +
                        getString(R.string.meter_sec)

                tvDateHome.text =
                    "${convertDate(data.list[0].dtTxt)[2]}, ${convertDate(data.list[0].dtTxt)[3]}"
                todayIn00.apply {
                    setTime("${convertDate(data.list[0].dtTxt)[4]}:${convertDate(data.list[0].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[0].weather[0].icon + "@2x.png")
                    setTemperature(data.list[0].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn03.apply {
                    setTime("${convertDate(data.list[1].dtTxt)[4]}:${convertDate(data.list[1].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[1].weather[0].icon + "@2x.png")
                    setTemperature(data.list[1].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn06.apply {
                    setTime("${convertDate(data.list[2].dtTxt)[4]}:${convertDate(data.list[2].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[2].weather[0].icon + "@2x.png")
                    setTemperature(data.list[2].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn09.apply{
                    setTime("${convertDate(data.list[3].dtTxt)[4]}:${convertDate(data.list[3].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[3].weather[0].icon + "@2x.png")
                    setTemperature(data.list[3].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn12.apply {
                    setTime("${convertDate(data.list[4].dtTxt)[4]}:${convertDate(data.list[4].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[4].weather[0].icon + "@2x.png")
                    setTemperature(data.list[4].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn15.apply {
                    setTime("${convertDate(data.list[5].dtTxt)[4]}:${convertDate(data.list[5].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[5].weather[0].icon + "@2x.png")
                    setTemperature(data.list[5].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn18.apply {
                    setTime("${convertDate(data.list[6].dtTxt)[4]}:${convertDate(data.list[6].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[6].weather[0].icon + "@2x.png")
                    setTemperature(data.list[6].main.temp.toInt().toString() + getString(R.string.сelsius))
                }
                todayIn21.apply {
                    setTime("${convertDate(data.list[7].dtTxt)[4]}:${convertDate(data.list[7].dtTxt)[5]}")
                    setImageFromApi("http://openweathermap.org/img/wn/" + data.list[7].weather[0].icon + "@2x.png")
                    setTemperature(data.list[7].main.temp.toInt().toString() + getString(R.string.сelsius))
                }

                tvTimeSunRiseHome.text = convertUnixToDate(data.city.sunrise)
                tvTimeSunSetHome.text = convertUnixToDate(data.city.sunset)

                weekDay1.apply {
                    setDay(convertUnixToWeekday(data.list[0].dt))
                }

                weekDay2.apply {
                    setDay(convertUnixToWeekday(data.list[7].dt))
                }

                weekDay3.apply {
                    setDay(convertUnixToWeekday(data.list[15].dt))
                }

                weekDay4.apply {
                    setDay(convertUnixToWeekday(data.list[23].dt))
                }

                weekDay5.apply {
                    setDay(convertUnixToWeekday(data.list[31].dt))
                }
            }
        }
    }

    private fun convertDate(date: String): Array<String> {
        val dateSplit = date.split(" ")[0]
        val timeSplit = date.split(" ")[1]

        val year = dateSplit.split("-")[0]
        val monthInt = dateSplit.split("-")[1]
        val day = dateSplit.split("-")[2]

        val hour = timeSplit.split(":")[0]
        val minutes = timeSplit.split(":")[1]

        val monthString = when(monthInt) {
            "01" -> "Jan"
            "02" -> "Feb"
            "03" -> "Mar"
            "04" -> "Apr"
            "05" -> "May"
            "06" -> "Jun"
            "07" -> "Jul"
            "08" -> "Ayg"
            "09" -> "Sep"
            "10" -> "Oct"
            "11" -> "Nov"
            "12" -> "Dec"
            else -> "Unknown"
        }
        return arrayOf(year, monthInt, monthString, day, hour, minutes)
    }


    @SuppressLint("SimpleDateFormat")
    private fun convertUnixToDate(unixDate: Int): String {
        val dv: Long = java.lang.Long.valueOf(unixDate.toLong()) * MILLISECONDS_FACTOR
        val df = Date(dv)
        val vv: String = SimpleDateFormat("MM dd, yyyy hh:mma").format(df)
        val time = vv.split(" ")
        return time[3].split("A")[0]
    }

    private fun convertUnixToWeekday(unixDate: Int): String {
        val daysSinceEpoch = unixDate / 86400
        return when((daysSinceEpoch + 4) % 7) {
            0 -> "Sun"
            1 -> "Mon"
            2 -> "Tue"
            3 -> "Wed"
            4 -> "Thu"
            5 -> "Fri"
            6 -> "Sat"
            else -> "Unknown"
        }
    }
}