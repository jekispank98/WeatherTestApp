package com.example.weathertestapp.data.network

import com.example.weathertestapp.data.model.weathermodel.ApiForecastModel
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import retrofit2.Response

interface GetForecastFromApi {

    suspend fun getCurrentWeather(): Response<WeatherModel>

    suspend fun getFiveDayForecastFromApi(): Response<ApiForecastModel>

//    suspend fun getNameOfLocation(lat: Double, lon: Double):
}