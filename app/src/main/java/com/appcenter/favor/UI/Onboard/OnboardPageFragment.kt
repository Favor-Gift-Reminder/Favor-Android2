package com.appcenter.favor.UI.Onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appcenter.favor.databinding.FragmentOnboardPageBinding

class OnboardPageFragment(private val img: Int, private val txt: String) : Fragment() {
    private lateinit var binding: FragmentOnboardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnboardPageBinding.inflate(inflater, container, false)
        binding.img.setBackgroundResource(img)
        binding.txt.text = txt
        return binding.root
    }
}