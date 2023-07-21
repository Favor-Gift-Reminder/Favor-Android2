package com.appcenter.favor.UI.Onboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.UI.LogIn.LoginMainFragment
import com.appcenter.favor.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {
    private lateinit var binding: FragmentOnboardBinding
    private lateinit var pages: ArrayList<OnboardPageFragment>
    private var page = 0

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (page != 0) prevPage()
                else parentContext.finish()
                binding.btn.apply {
                    text = ""
                    backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.white)
                }
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
        binding = FragmentOnboardBinding.inflate(inflater, container, false)

        pages = arrayListOf(
            OnboardPageFragment(R.drawable.tmp_back_rectangle_8, "특별한 선물을 받은\n오늘의 감정을 기록해요"),
            OnboardPageFragment(R.drawable.tmp_back_rectangle_8, "기억하고 싶은 기념일\n페이버가 대신 챙겨드려요"),
            OnboardPageFragment(R.drawable.tmp_back_rectangle_8, "고마운 마음을 담아\n메시지를 전달해요")
        )

        binding.btn.setOnClickListener {
            if (page != 2) nextPage()
            else parentFragmentManager.beginTransaction()
                .replace(parentContext.binding.container.id, LoginMainFragment())
                .commit()

            if (page == 2) binding.btn.apply {
                text = "시작하기"
                backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.main)
            }
        }

        childFragmentManager.beginTransaction()
            .replace(binding.container.id, pages[0])
            .commit()

        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun nextPage() {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            .replace(binding.container.id, pages[++page])
            .commit()

        for (i in arrayOf(0, 1, 2)) {
            (binding.pageIndex.getChildAt(i) as ImageView).imageTintList = when (i == page) {
                false -> ContextCompat.getColorStateList(requireContext(), R.color.line3)
                true -> ContextCompat.getColorStateList(requireContext(), R.color.icon)
            }
        }
    }

    private fun prevPage() {
        childFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
            .replace(binding.container.id, pages[--page])
            .commit()

        for (i in arrayOf(0, 1, 2)) {
            (binding.pageIndex.getChildAt(i) as ImageView).imageTintList = when (i == page) {
                false -> ContextCompat.getColorStateList(requireContext(), R.color.line3)
                true -> ContextCompat.getColorStateList(requireContext(), R.color.icon)
            }
        }
    }
}