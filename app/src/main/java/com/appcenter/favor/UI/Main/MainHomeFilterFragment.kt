package com.appcenter.favor.UI.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appcenter.favor.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainHomeFilterFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.Theme_Favor_BottomSheet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_home_filter, container, false)
    }
}