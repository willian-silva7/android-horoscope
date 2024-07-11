package com.stellantis.horoscapp.data.network.response

import com.stellantis.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest{
    @Test
    fun `toDomain should return a correct PredictionModel`(){
        // Given
        val horoscopeResponse = anyResponse.copy(sign = "aries")
        // When
        val predictionModel = horoscopeResponse.toDomain()

        // Them
        predictionModel?.horoscope shouldBe horoscopeResponse.horoscope
        predictionModel?.sign shouldBe horoscopeResponse.sign
    }
}