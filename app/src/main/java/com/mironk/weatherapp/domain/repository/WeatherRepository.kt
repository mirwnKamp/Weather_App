package com.mironk.weatherapp.domain.repository

import com.mironk.weatherapp.domain.models.Weather

interface WeatherRepository {
    suspend fun getWeatherData(): State<Weather>
}