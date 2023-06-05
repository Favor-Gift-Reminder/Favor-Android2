package com.appcenter.favor.UI.Reminder

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentReminderBinding
import java.text.SimpleDateFormat

class ReminderFragment : Fragment() {
    private lateinit var binding: FragmentReminderBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity

        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@ReminderFragment)
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentReminderBinding.inflate(inflater, container, false)

        init_toolbar()
        binding.root.setOnClickListener {}
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.title.text = SimpleDateFormat("yyyy년 MM월").format(System.currentTimeMillis())
        binding.toolbar.sub1.setImageResource(R.drawable.icon_default_noti_add)
        binding.toolbar.sub1.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, ReminderModifyFragment())
                .commit()
        }
        binding.toolbar.dropdown.setOnClickListener { ReminderDialogFragment().show(childFragmentManager, "") }

    }
}