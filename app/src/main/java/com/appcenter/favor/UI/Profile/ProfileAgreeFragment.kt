package com.appcenter.favor.UI.Profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.UI.Main.MainFragment
import com.appcenter.favor.databinding.FragmentProfileAgreeBinding

class ProfileAgreeFragment : Fragment() {
    private lateinit var binding: FragmentProfileAgreeBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@ProfileAgreeFragment)
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
        binding = FragmentProfileAgreeBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(parentContext.binding.container.id, MainFragment())
                .commit()
        }

        binding.root.setOnClickListener{}
        return binding.root
    }

}