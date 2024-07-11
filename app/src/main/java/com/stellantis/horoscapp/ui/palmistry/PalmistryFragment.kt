package com.stellantis.horoscapp.ui.palmistry

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.stellantis.horoscapp.R
import com.stellantis.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint
import java.security.Permission

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    companion object{
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private  val requestPermissonLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {isGranted ->
        if (isGranted) {
            // start camera
        }else {
            showToast("Aceite as permissões para desfrutar de uma experiencia mágica!")
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()){

        }else{
            requestPermissonLauncher.launch(CAMERA_PERMISSION)

        }
    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}