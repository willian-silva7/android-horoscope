package com.stellantis.horoscapp.ui.detail

import com.stellantis.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState{
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Sucess(val predict: String, val sign: String, var horoscopeModel: HoroscopeModel ): HoroscopeDetailState()
}
