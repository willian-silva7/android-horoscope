package com.stellantis.horoscapp.ui.detail

import java.lang.Error

sealed class HoroscopeDetailState{
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Sucess(val data: String): HoroscopeDetailState()
}
