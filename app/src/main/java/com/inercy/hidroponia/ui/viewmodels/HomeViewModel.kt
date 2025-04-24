package com.inercy.hidroponia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inercy.hidroponia.data.remote.api.Constant
import com.inercy.hidroponia.data.remote.api.NetworkResponse
import com.inercy.hidroponia.data.remote.api.RetrofitInstance
import com.inercy.hidroponia.data.remote.api.WeatherModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    init {
        getData()
    }

    fun getData(city: String = "Mexicali") {
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(Constant.API_KEY, city, 1)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = (NetworkResponse.Success(it))
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Fallo la carga de datos")
                }
            } catch (e: Exception) {
                _weatherResult.value = NetworkResponse.Error("Fallo la carga de datos")
            }
        }
    }
}