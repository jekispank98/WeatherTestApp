package com.example.weathertestapp.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertestapp.domain.GetForecastUseCase
import com.example.weathertestapp.domain.model.currentweather.WeatherModel
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    private val application: Application
) : ViewModel() {

    private var _currentForecast = MutableLiveData<WeatherModel?>()
    val currentForecast: LiveData<WeatherModel?> = _currentForecast

    private var _fiveDayForecast = MutableLiveData<List<FiveDayModel>?>()
    val fiveDayForecast: LiveData<List<FiveDayModel>?> = _fiveDayForecast


    fun getCurrentForecast() {
        try {
            viewModelScope.launch {
                val result =
                    getForecastUseCase.getCurrentForecastUseCase()
                _currentForecast.value = result
            }
        } catch (e: Exception) {
            getToast()
        }
    }

    fun getFiveDayForecast() {
        try {
            viewModelScope.launch {
                val result = getForecastUseCase.getFiveDayForecastFromApi()
                _fiveDayForecast.value = result
            }
        } catch (e: Exception) {
            getToast()
        }
    }

    private fun getToast() {
        Toast.makeText(
            application.applicationContext,
            "Something wrong. Please, update",
            Toast.LENGTH_SHORT
        ).show()
    }
}