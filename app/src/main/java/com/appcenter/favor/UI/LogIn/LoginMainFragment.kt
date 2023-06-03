package com.appcenter.favor.UI.LogIn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.UI.Join.JoinFragment
import com.appcenter.favor.databinding.FragmentLoginMainBinding

class LoginMainFragment : Fragment() {
    private lateinit var binding: FragmentLoginMainBinding
    private lateinit var parentContext: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginMainBinding.inflate(inflater, container, false)

        binding.btnLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, LoginFragment())
                .commit()
        }

        binding.btnJoin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, JoinFragment())
                .commit()
        }

        binding.root.setOnClickListener{}
        return binding.root
    }
}