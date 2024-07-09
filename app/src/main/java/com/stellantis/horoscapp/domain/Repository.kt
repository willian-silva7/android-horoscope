package com.stellantis.horoscapp.domain

import com.stellantis.horoscapp.data.network.response.PredictionResponse
import com.stellantis.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}