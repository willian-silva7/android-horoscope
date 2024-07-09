package com.stellantis.horoscapp.ui.detail

sealed class HoroscopeDetailState{
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Sucess(val predict: String, val sign: String ): HoroscopeDetailState()
}
