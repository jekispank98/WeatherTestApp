package com.example.weathertestapp.data.network

import com.example.weathertestapp.data.model.weathermodel.ApiForecastModel
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import retrofit2.Response

class GetForecastFromApiImpl(private val weatherApiService: WeatherApiService): GetForecastFromApi {
    override suspend fun getCurrentWeather(): Response<WeatherModel> {
        return weatherApiService.getCurrentWeather()
    }

    override suspend fun getFiveDayForecastFromApi(): Response<ApiForecastModel> {
        return weatherApiService.getFiveDayWeather()
    }
}