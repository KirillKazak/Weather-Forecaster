package com.kirill1995.kazzak.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirill1995.kazzak.domain.models.geo.GeoModel
import com.kirill1995.kazzak.domain.models.weather.threeHourForecastFiveDays.ThreeHourForecastFiveDaysModel
import com.kirill1995.kazzak.domain.usesCases.geo.GetGeoDataUseCase
import com.kirill1995.kazzak.domain.usesCases.weather.GetThreeHourForecastFiveDaysDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val getThreeHourForecastFiveDaysDataUseCase: GetThreeHourForecastFiveDaysDataUseCase,
    private val getGeoDataUseCase: GetGeoDataUseCase
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val threeHourForecastFiveDaysLiveData =
        MutableLiveData<ThreeHourForecastFiveDaysModel>()
    val geoLiveData =
        MutableLiveData<GeoModel>()
    val errorLiveData = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getThreeHourForecastFiveDaysData(cityWithCountryCode: String) {
        compositeDisposable.add(
            getThreeHourForecastFiveDaysDataUseCase
                .getThreeHourForecastFiveDaysData(cityWithCountryCode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    threeHourForecastFiveDaysLiveData.postValue(it)
                }, {
                    errorLiveData.postValue("Error")
                })
        )
    }

    fun getGeoData() {
        compositeDisposable.add(
            getGeoDataUseCase.getGeoData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    geoLiveData.postValue(it)
                }, {
                    errorLiveData.postValue("Error")
                })
        )
    }
}