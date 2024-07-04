package com.stellantis.horoscapp.data.providers

import com.stellantis.horoscapp.domain.model.HoroscopeInfo
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Aries
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Leo
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Libra
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.stellantis.horoscapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo>{
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}