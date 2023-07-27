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
import com.appcenter.favor.UI.Reminder.ReminderFragment
import com.appcenter.favor.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {
    private lateinit var binding: FragmentGiftBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@GiftFragment)
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
        binding = FragmentGiftBinding.inflate(inflater, container, false)

        init_toolbar()
        binding.btnSelectFriend.setOnClickListener{
            parentContext.supportFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, GiftFriendFragment())
                .commit()
        }
        binding.btnSelectDate.setOnClickListener {  }
        val
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.back.setImageResource(R.drawable.icon_arrow_down)
        binding.toolbar.icon.setImageResource(R.drawable.icon_default_gift)
        binding.toolbar.sub1.hint = "등록"
    }
}