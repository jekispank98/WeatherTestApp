package com.example.weathertestapp.di

import com.example.weathertestapp.data.WeatherRepositoryImpl
import com.example.weathertestapp.data.network.GetForecastFromApi
import com.example.weathertestapp.data.network.GetForecastFromApiImpl
import com.example.weathertestapp.data.network.WeatherApiService
import com.example.weathertestapp.domain.GetForecastUseCase
import com.example.weathertestapp.domain.WeatherRepository
import com.example.weathertestapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

val mainModule = module {

    single<WeatherApiService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    single<GetForecastFromApi> {
        GetForecastFromApiImpl(weatherApiService = get())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(getForecastFromApi = get())
    }

    factory {
        GetForecastUseCase(weatherRepository = get())
    }

    viewModel {
        MainViewModel(
            getForecastUseCase = get(),
            application = get()
        )
    }
}