package com.appcenter.favor.UI.Reminder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentReminderBinding
import com.appcenter.favor.databinding.FragmentReminderDialogBinding
import java.text.SimpleDateFormat

class ReminderDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentReminderDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentReminderDialogBinding.inflate(inflater, container, false)
        binding.dateYear.text = SimpleDateFormat("yyyy년").format(System.currentTimeMillis())
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }
}