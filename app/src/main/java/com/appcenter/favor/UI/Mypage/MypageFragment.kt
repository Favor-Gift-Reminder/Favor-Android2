package com.appcenter.favor.UI.Mypage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private lateinit var binding: FragmentMypageBinding

    private lateinit var parentContext: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMypageBinding.inflate(inflater, container, false)

        binding.appbar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val ratio = kotlin.math.abs(verticalOffset).toFloat() / binding.appbar.totalScrollRange
            binding.back.setPadding(0, (binding.toolbar1.root.height * ratio).toInt(), 0, 0)
            if(ratio >= 0.9f) {
                binding.toolbar1.root.visibility = View.GONE
                binding.toolbar2.root.visibility = View.VISIBLE
            }
            else {
                binding.toolbar1.root.visibility = View.VISIBLE
                binding.toolbar2.root.visibility = View.GONE
            }
        }

        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun init_toolbar() {
        binding.toolbar1.title.text = "Favor"
        binding.toolbar1.sub1.setImageResource(R.drawable.icon_default_edit)
        binding.toolbar1.sub2.setImageResource(R.drawable.icon_default_setting)
        binding.toolbar2.title.text = "Name"
        binding.toolbar2.root.setBackgroundColor(0xFFFFFFFF.toInt())
    }
}