package com.mironk.weatherapp.presentation.ui.dailyWeather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mironk.weatherapp.domain.models.Weather
import com.mironk.weatherapp.domain.repository.State
import com.mironk.weatherapp.domain.repository.WeatherRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(private val repositoryImpl: WeatherRepositoryImpl)
    : ViewModel() {
    var state by mutableStateOf(DailyWeatherState())
            private set

    init {
        viewModelScope.launch {
            state = DailyWeatherState(repositoryImpl.getWeatherData())

        }
    }
}

data class DailyWeatherState(
    val weather: State<Weather> = State.Loading()
)