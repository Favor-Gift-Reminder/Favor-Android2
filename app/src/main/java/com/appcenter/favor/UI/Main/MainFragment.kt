package com.appcenter.favor.UI.Main

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.forEach
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.UI.Home.HomeFragment
import com.appcenter.favor.UI.Mypage.MypageFragment
import com.appcenter.favor.UI.Profile.ProfileAgreeFragment
import com.appcenter.favor.databinding.FragmentMainBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

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
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
        }

        init_appBar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_appBar() {
        val dp_24 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24F, requireContext().resources.displayMetrics)
        val bar = binding.bar.background as MaterialShapeDrawable
        bar.shapeAppearanceModel = bar.shapeAppearanceModel.toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, dp_24)
            .setTopRightCorner(CornerFamily.ROUNDED, dp_24)
            .build()

        binding.nav.menu.forEach {
            binding.nav.findViewById<View>(it.itemId).setOnLongClickListener { true }
        }

        binding.nav.setOnItemSelectedListener {
            if(binding.nav.selectedItemId == it.itemId) return@setOnItemSelectedListener false
            childFragmentManager.beginTransaction()
                .replace(binding.container.id, when(it.itemId) {
                    R.id.menu_home -> HomeFragment()
                    R.id.menu_mypage -> MypageFragment()
                    else -> null
                }!!).commit()
            return@setOnItemSelectedListener true
        }
    }
}