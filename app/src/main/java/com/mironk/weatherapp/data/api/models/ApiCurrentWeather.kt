package com.mironk.weatherapp.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCurrentWeather(
    @Json(name = "temperature")
    val temperature: Double,
    @Json(name = "time")
    val time: Long,
    @Json(name = "weathercode")
    val weatherCode: Int,
    @Json(name = "winddirection")
    val windDirection: Double,
    @Json(name = "windspeed")
    val windSpeed: Double
)