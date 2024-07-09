package com.stellantis.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.stellantis.horoscapp.databinding.ActivityHoroscopeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel:HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    private fun initUI() {
        initState()
    }

    private fun initState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{loading ->
                    when(loading){
                        is HoroscopeDetailState.Error -> loadingState()
                        HoroscopeDetailState.Loading -> errorState()
                        is HoroscopeDetailState.Sucess -> successState(loading)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Sucess) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.predict
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }
}