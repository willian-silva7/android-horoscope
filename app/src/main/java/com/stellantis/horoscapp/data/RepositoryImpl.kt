package com.stellantis.horoscapp.data

import android.util.Log
import com.stellantis.horoscapp.data.network.HoroscopeApiService
import com.stellantis.horoscapp.data.network.response.PredictionResponse
import com.stellantis.horoscapp.domain.Repository
import com.stellantis.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        kotlin.runCatching { apiService.getHoroscope(sign = sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Arisdevs", "Ha occorrido un error ${it.message}") }

        return null
    }

}