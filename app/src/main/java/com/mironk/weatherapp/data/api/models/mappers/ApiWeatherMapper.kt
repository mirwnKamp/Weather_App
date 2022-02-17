package com.mironk.weatherapp.data.api.models.mappers

import com.mironk.weatherapp.data.api.models.ApiWeather
import com.mironk.weatherapp.domain.models.Weather
import javax.inject.Inject

class ApiWeatherMapper @Inject constructor(
    private val apiDailyMapper: ApiDailyMapper,
    private val apiCurrentWeatherMapper: CurrentWeatherMapper
): ApiMapper<Weather, ApiWeather> {
    override fun mapToDomain(apiEntity: ApiWeather): Weather {
        return Weather(
            currentWeather = apiCurrentWeatherMapper.mapToDomain(apiEntity.currentWeather),
            daily = apiDailyMapper.mapToDomain(apiEntity.daily)
        )
    }

}