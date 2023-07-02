package com.example.weathertestapp.domain

import android.util.Log
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel

class GetForecastUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun getCurrentForecastUseCase() : WeatherModel? {
        return weatherRepository.getCurrentForecast()
    }

    suspend fun getFiveDayForecastFromApi(): List<FiveDayModel>? {
        return weatherRepository.getFiveDayForecastFromApi()
    }
}