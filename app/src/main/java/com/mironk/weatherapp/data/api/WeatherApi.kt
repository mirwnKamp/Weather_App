package com.mironk.weatherapp.data.api

import com.mironk.weatherapp.data.api.models.ApiWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getWeatherData(
        @Query(ApiParameters.LATITUDE) latitude:Float = -6.80f,
        @Query(ApiParameters.LONGITUDE) longitude:Float = 39.28f,
        @Query(ApiParameters.DAILY) daily: Array<String> = arrayOf(
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "windspeed_10m_max",
            "winddirection_10m_dominant"
        ),
        @Query(ApiParameters.CURRENT_WEATHER) currentWeather: Boolean = true,
        @Query(ApiParameters.TIME_FORMAT) timeformat: String = "unixtime",
        @Query(ApiParameters.TIMEZONE) timeZone: String = "Africa/Dar_es_Salaam"
    ): ApiWeather
}