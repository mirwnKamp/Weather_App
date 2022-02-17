package com.mironk.weatherapp.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiDailyUnits(
    @Json(name = "temperature_2m_max")
    val temperature2mMax: String,
    @Json(name = "temperature_2m_min")
    val temperature2mMin: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "weathercode")
    val weathercode: String,
    @Json(name = "winddirection_10m_dominant")
    val winddirection10mDominant: String,
    @Json(name = "windspeed_10m_max")
    val windspeed10mMax: String
)