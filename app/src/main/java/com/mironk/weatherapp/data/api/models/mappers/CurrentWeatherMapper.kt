package com.mironk.weatherapp.data.api.models.mappers

import com.mironk.weatherapp.data.api.models.ApiCurrentWeather
import com.mironk.weatherapp.domain.models.CurrentWeather
import com.mironk.weatherapp.utils.Util
import javax.inject.Inject

class CurrentWeatherMapper @Inject constructor() : ApiMapper<CurrentWeather, ApiCurrentWeather> {
    override fun mapToDomain(apiEntity: ApiCurrentWeather): CurrentWeather {
        return CurrentWeather(
            temperature = apiEntity.temperature,
            time = parseTime(apiEntity.time),
            weatherStatus = parseWeatherStatus(apiEntity.weatherCode),
            windDirection = parseWindDirection(apiEntity.windDirection),
            windSpeed = apiEntity.windSpeed
        )
    }

    private fun parseTime(time: Long): String{
       return Util.formatDate("E", time)
    }

    private fun parseWeatherStatus(code: Int): String {
        return Util.getWeatherInfo(code = code)
    }

    private fun parseWindDirection(windDirections: Double): String {
        return Util.getWindDirection(windDirections)
    }
}