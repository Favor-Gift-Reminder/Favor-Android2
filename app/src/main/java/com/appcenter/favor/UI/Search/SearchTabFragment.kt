package com.appcenter.favor.UI.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.TooltipCompat
import androidx.fragment.app.Fragment
import com.appcenter.favor.databinding.FragmentSearchTabBinding

class SearchTabFragment : Fragment() {
    private lateinit var binding: FragmentSearchTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchTabBinding.inflate(inflater, container, false)

        for (i in 0 until binding.tab.tabCount)
            TooltipCompat.setTooltipText(binding.tab.getTabAt(i)!!.view, null)

        binding.root.setOnClickListener {}
        return binding.root
    }
}