package com.mironk.weatherapp.data.api

object ApiConstants {
    const val API_BASE_URL = "https://api.open-meteo.com/v1/"
    const val END_POINT = "forecast"
}

object ApiParameters {
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
    const val DAILY = "daily"
    const val CURRENT_WEATHER = "current_weather"
    const val TIME_FORMAT = "timeformat"
    const val TIMEZONE = "timezone"
}