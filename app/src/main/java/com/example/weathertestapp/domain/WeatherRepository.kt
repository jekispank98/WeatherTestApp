package com.example.weathertestapp.domain

import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel

interface WeatherRepository {

    suspend fun getCurrentForecast(): WeatherModel?

    suspend fun getFiveDayForecastFromApi(): List<FiveDayModel>?
}