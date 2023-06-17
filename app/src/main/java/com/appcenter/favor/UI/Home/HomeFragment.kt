package com.appcenter.favor.UI.Home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.TooltipCompat
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.UI.Reminder.ReminderFragment
import com.appcenter.favor.UI.Search.SearchFragment
import com.appcenter.favor.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        childFragmentManager.beginTransaction()
            .add(binding.containerUpcoming.id, HomeBlankFragment(R.drawable.tmp_back_rectangle_8, "이벤트가 없습니다."))
            .add(binding.containerTimeline.id, HomeBlankFragment(R.drawable.tmp_back_rectangle_8, "선물 기록이 없습니다."))
            .commit()

        binding.btnFilter.setOnClickListener { HomeFilterFragment().show(childFragmentManager, "") }
        binding.btnMore.setOnClickListener {
            parentContext.supportFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, ReminderFragment())
                .commit()
        }

        for(i in 0 until binding.tab.tabCount)
            TooltipCompat.setTooltipText(binding.tab.getTabAt(i)!!.view, null)

        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.sub1.setImageResource(R.drawable.icon_default_search)
        binding.toolbar.sub1.setOnClickListener {
            parentContext.supportFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, SearchFragment())
                .commit()
        }
    }
}