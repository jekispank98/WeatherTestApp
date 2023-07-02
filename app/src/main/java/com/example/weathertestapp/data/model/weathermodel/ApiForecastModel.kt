package com.example.weathertestapp.data.model.weathermodel

data class ApiForecastModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Entity>,
    val message: Int
)