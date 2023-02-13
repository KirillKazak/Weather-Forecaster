package com.kirill1995.kazzak.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kirill1995.kazzak.R
import com.kirill1995.kazzak.databinding.ActivityMainBinding
import com.kirill1995.kazzak.ui.weatherInCurrentLocation.WeatherInCurrentLocationFragment
import com.kirill1995.kazzak.ui.weatherInCurrentLocation.WeatherInCurrentLocationViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vbMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vbMain.root)

        supportFragmentManager.beginTransaction().add(
            vbMain.mainContainer.id,
            WeatherInCurrentLocationFragment()
        ).commit()
    }
}