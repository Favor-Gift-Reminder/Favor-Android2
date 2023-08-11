package com.appcenter.favor.UI.Gift

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentGiftBinding
import com.appcenter.favor.databinding.FragmentGiftFriendBinding

class GiftFriendFragment : Fragment() {
    private lateinit var binding : FragmentGiftFriendBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@GiftFriendFragment)
                    .commit()
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
        binding = FragmentGiftFriendBinding.inflate(inflater, container, false)
        init_toolbar()
        binding.toolbar.sub1.setOnClickListener {

        }
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.back.setImageResource(R.drawable.icon_arrow_left)
        binding.toolbar.icon.setImageResource(R.drawable.icon_default_friend)
        binding.toolbar.sub1.hint = "완료"
    }
}