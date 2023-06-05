package com.appcenter.favor.UI.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appcenter.favor.databinding.FragmentSearchRecentBinding

class SearchRecentFragment : Fragment() {
    private lateinit var binding: FragmentSearchRecentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchRecentBinding.inflate(inflater, container, false)

        binding.root.setOnClickListener{}
        return binding.root
    }
}