package com.mironk.weatherapp.domain.repository

import com.mironk.weatherapp.data.api.WeatherApi
import com.mironk.weatherapp.data.api.models.mappers.ApiWeatherMapper
import com.mironk.weatherapp.domain.models.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val apiWeatherMapper: ApiWeatherMapper
): WeatherRepository {
    override suspend fun getWeatherData(): State<Weather> {
        return try {
            val apiWeather = weatherApi.getWeatherData()
            val weather = apiWeatherMapper.mapToDomain(apiWeather)
            State.Success(weather)
        } catch (e: Exception) {
            e.printStackTrace()
            State.Error(e.message.orEmpty())
        }
    }

}