package com.example.weathertestapp.data

import android.util.Log
import com.example.weathertestapp.data.network.GetForecastFromApi
import com.example.weathertestapp.domain.WeatherRepository
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel

class WeatherRepositoryImpl(private val getForecastFromApi: GetForecastFromApi) :
    WeatherRepository {

    val mapper = Mapper()

    override suspend fun getCurrentForecast(): WeatherModel? {
        return getForecastFromApi.getCurrentWeather().body()
    }

    override suspend fun getFiveDayForecastFromApi(): List<FiveDayModel>? {
        return getForecastFromApi.getFiveDayForecastFromApi().body()
            ?.let { mapper.listApiModelToListDomainModel(it) }

    }
}