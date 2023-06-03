package com.appcenter.favor.UI.Join

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.UI.Profile.ProfileCreateFragment
import com.appcenter.favor.databinding.FragmentJoinBinding

class JoinFragment : Fragment() {
    private lateinit var binding: FragmentJoinBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity

        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@JoinFragment)
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
        binding = FragmentJoinBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, ProfileCreateFragment())
                .commit()
        }

        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.title.text = "회원가입"
    }
}