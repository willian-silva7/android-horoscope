package com.stellantis.horoscapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.stellantis.horoscapp.R
import com.stellantis.horoscapp.databinding.FragmentLuckBinding
import com.stellantis.horoscapp.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCardProvider: RandomCardProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        preparePredction()
        initListeners()
    }

    private fun preparePredction() {
        val currentLuck = randomCardProvider.getLucky()
        currentLuck?.let {luck ->
            val currentPrediction = getString(luck.text)
            binding.tvLucky.text = getString(luck.text)
            binding.ivLuckyCard.setImageResource(luck.image)
            binding.tvShare.setOnClickListener{ shareResult(currentPrediction)}
        }
    }

    private fun shareResult(string: String) {

    }

    private fun initListeners() {
        binding.ivRoulette.setOnClickListener{ spinRoulette()}
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees = random.nextInt(1400) + 360
        val animator = ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimator = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        slideUpAnimator.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.reverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.reverse.startAnimation(slideUpAnimator)
    }

    private fun growCard() {
        val growAnimator = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)

        growAnimator.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.reverse.startAnimation(growAnimator)
    }

    private fun showPremonitionView() {
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        binding.preview.startAnimation(disappearAnimation)
        binding.prediction.startAnimation(appearAnimation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}