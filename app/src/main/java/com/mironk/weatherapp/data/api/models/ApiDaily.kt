package com.mironk.weatherapp.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiDaily(
    @Json(name = "temperature_2m_max")
    val temperatureMax: List<Double>,
    @Json(name = "temperature_2m_min")
    val temperatureMin: List<Double>,
    @Json(name = "time")
    val time: List<Long>,
    @Json(name = "weathercode")
    val weatherCode: List<Int>,
    @Json(name = "winddirection_10m_dominant")
    val windDirection: List<Double>,
    @Json(name = "windspeed_10m_max")
    val windSpeed: List<Double>
)