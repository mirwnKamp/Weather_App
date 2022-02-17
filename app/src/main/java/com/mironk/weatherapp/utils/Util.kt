package com.mironk.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object Util {
    private val DIRECTIONS = listOf(
        "North",
        "North East",
        "East",
        "South East",
        "South",
        "South West",
        "West",
        "North West"
    )

    fun formatDate(pattern: String, time: Long): String{
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(time * 1000)
    }

    fun getWindDirection(windDirection: Double): String {
        return DIRECTIONS[(windDirection % 360 / 45 % 8).toInt()]
    }

    fun getWeatherInfo(code: Int) : String {
       return when(code) {
            0 -> "Clear sky"
            1 -> "Mainly clear"
            2 -> "Partly cloud"
            3 -> "Overcast"
            45, 48 -> "Fog"
            51, 53, 55 -> "Drizzle"
            56, 57 -> "Freezing Drizzle"
            61 -> "Rain: Slight"
            63 -> "Rain: Moderate"
            65 -> "Rain: Heavy"
            66, 67 -> "Freezing Rain"
            71 -> "Snow fall: Slight"
            73 -> "Snow fall: Moderate"
            75 -> "Snow fall: Heavy"
            77 -> "Snow grains"
            80, 81, 82 -> "Rain showers: Slight"
            85, 86 -> "Snow showers: Slight"
            95, 96, 99 -> "Thunderstorm: Slight"
            else -> "Unknown"
        }
    }






}