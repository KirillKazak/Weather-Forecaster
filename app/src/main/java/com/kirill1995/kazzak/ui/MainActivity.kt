package com.kirill1995.kazzak.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kirill1995.kazzak.databinding.ActivityMainBinding
import com.kirill1995.kazzak.ui.weatherInCurrentLocation.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var vbMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vbMain.root)

        supportFragmentManager.beginTransaction().add(
            vbMain.mainContainer.id,
            HomeFragment()
        ).commit()
    }
}