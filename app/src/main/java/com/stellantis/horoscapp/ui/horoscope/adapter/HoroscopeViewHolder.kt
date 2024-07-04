package com.stellantis.horoscapp.ui.horoscope.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stellantis.horoscapp.databinding.ItemHoroscopeBinding
import com.stellantis.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo) {
        val context: Context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getText(horoscopeInfo.name)
    }
}