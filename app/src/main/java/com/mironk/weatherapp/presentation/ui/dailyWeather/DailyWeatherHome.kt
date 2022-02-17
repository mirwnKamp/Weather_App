package com.mironk.weatherapp.presentation.ui.dailyWeather

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mironk.weatherapp.domain.models.CurrentWeather
import com.mironk.weatherapp.domain.models.Daily
import com.mironk.weatherapp.domain.repository.State

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyWeatherHomeScreen() {
    val dailyWeatherViewModel = viewModel(modelClass = DailyWeatherViewModel::class.java)
    val state = dailyWeatherViewModel.state.weather
    val dailyWeatherInfo = state.data?.daily?.weatherInfo ?: emptyList()
    val gradientColors = listOf(
        Color(0xFFE7F7FF),
        Color(0xFF0D9DE3)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(gradientColors))
    ) {

        when (state) {

            is State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
            is State.Success -> {
                state.data?.currentWeather?.let {
                    CurrentWeatherCard(currentWeather = it)
                }

                LazyVerticalGrid(cells = GridCells.Fixed(2)) {

                    items(dailyWeatherInfo) { weatherInfo ->
                        DailyWeatherCard(dailyWeatherInfo = weatherInfo)

                    }
                }

            }
            is State.Error -> {
                Log.e("Error", "DailyWeatherHomeScreen: ${state.message}")
            }
        }
    }
}

@Composable
fun DailyWeatherCard(dailyWeatherInfo: Daily.WeatherInfo) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface.copy(1f)
    ) {
        Column(
            Modifier.padding(4.dp)
        ) {
            Text(
                text = dailyWeatherInfo.time,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
            Text(
                text = "${dailyWeatherInfo.temperatureMax} °C /" +
                        " ${dailyWeatherInfo.temperatureMin} °C"
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = dailyWeatherInfo.weatherStatus)
            Text(text = dailyWeatherInfo.windDirection)
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = dailyWeatherInfo.windSpeed.toString() + "kph")
        }
    }

}

@Composable
fun CurrentWeatherCard(currentWeather: CurrentWeather) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface.copy(1f)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = currentWeather.time)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(4.dp)
            ) {
                Column {
                    Text(text = "${currentWeather.temperature} °C")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = currentWeather.weatherStatus)
                }
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(text = currentWeather.windDirection)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = currentWeather.windSpeed.toString() + "kph")
                }
                Spacer(modifier = Modifier.size(8.dp))

            }

        }
    }

}