package com.stellantis.horoscapp.ui.horoscope.adapter

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.stellantis.horoscapp.databinding.ItemHoroscopeBinding
import com.stellantis.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit, ) {
        val context: Context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getText(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimate(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimate(view: View, newLambda:()-> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{newLambda()}
            start()
        }
    }
}