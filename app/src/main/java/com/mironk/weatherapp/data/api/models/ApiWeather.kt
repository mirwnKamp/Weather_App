package com.mironk.weatherapp.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiWeather(
    @Json(name = "current_weather")
    val currentWeather: ApiCurrentWeather,
    @Json(name = "daily")
    val daily: ApiDaily,
    @Json(name = "daily_units")
    val dailyUnits: ApiDailyUnits,
    @Json(name = "elevation")
    val elevation: Int,
    @Json(name = "generationtime_ms")
    val generationTimeMs: Double,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int
)