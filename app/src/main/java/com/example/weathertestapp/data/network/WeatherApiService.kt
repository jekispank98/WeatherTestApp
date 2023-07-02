package com.example.weathertestapp.data.network

import com.example.weathertestapp.data.model.weathermodel.ApiForecastModel
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApiService {

    @GET("weather?lat=59.938955&lon=30.315644&appid=d9e6fe2ca9bd114df14262b014663852&units=metric")
    suspend fun getCurrentWeather(): Response<WeatherModel>

    @GET("forecast?lat=59.938955&lon=30.315644&appid=d9e6fe2ca9bd114df14262b014663852&units=metric")
    suspend fun getFiveDayWeather(): Response<ApiForecastModel>
}