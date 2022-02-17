package com.mironk.weatherapp.domain.models

data class Daily(
    private val temperatureMax: List<Double>,
    private val temperatureMin: List<Double>,
    private val time: List<String>,
    private val weatherStatus: List<String>,
    private val windDirection: List<String>,
    private val windSpeed: List<Double>
){
    val weatherInfo: List<WeatherInfo>
    get()  {
        val dailyWeatherInfo = mutableListOf<WeatherInfo>()
        for (i in temperatureMax.indices){
            dailyWeatherInfo.add(
                WeatherInfo(
                    temperatureMax = temperatureMax[i],
                    temperatureMin = temperatureMin[i],
                    time = time[i],
                    weatherStatus = weatherStatus[i],
                    windDirection = windDirection[i],
                    windSpeed = windSpeed[i]
                )
            )
        }
        return dailyWeatherInfo
    }

    data class WeatherInfo(
        val temperatureMax: Double,
        val temperatureMin: Double,
        val time: String,
        val weatherStatus: String,
        val windDirection: String,
        val windSpeed: Double
    )
}
