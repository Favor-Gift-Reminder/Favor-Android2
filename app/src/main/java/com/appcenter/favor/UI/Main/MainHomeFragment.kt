package com.appcenter.favor.UI.Main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentMainHomeBinding

class MainHomeFragment : Fragment() {
    private lateinit var binding: FragmentMainHomeBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity

        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentContext.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressed)
    }

    override fun onDetach() {
        super.onDetach()
        onBackPressed.remove()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)

        childFragmentManager.beginTransaction()
            .add(binding.containerUpcoming.id, MainHomeBlankFragment(R.drawable.tmp_back_rectangle, "이벤트가 없습니다."))
            .add(binding.containerTimeline.id, MainHomeBlankFragment(R.drawable.tmp_back_rectangle, "선물 기록이 없습니다."))
            .commit()

        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.sub1.setImageResource(R.drawable.icon_default_search)
    }
}