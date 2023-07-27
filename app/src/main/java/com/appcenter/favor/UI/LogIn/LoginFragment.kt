package com.appcenter.favor.UI.LogIn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.appcenter.favor.Interface.ResponseDTO.signIn
import com.appcenter.favor.MainActivity
import com.appcenter.favor.UI.Main.MainFragment
import com.appcenter.favor.UI.Password.PasswordInputEmailFragment
import com.appcenter.favor.UserData
import com.appcenter.favor.databinding.FragmentLoginBinding
import com.nise.favor_android.Login.LoginRequest
import com.nise.favor_android.Repository.userRepository

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@LoginFragment)
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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        var repo = userRepository()
        binding.btnLoginFavor.setOnClickListener {
            val loginRequest = LoginRequest(
                binding.email.text.toString().trim(),
                binding.password.text.toString().trim()
            )
            repo.Login(loginRequest,object : userRepository.GetDataCallBack<signIn>{
                override fun onSuccess(data: signIn?) {
                    parentFragmentManager.beginTransaction()
                        .replace(parentContext.binding.container.id, MainFragment())
                        .commit()
                }
                override fun onFailure() {
                }
            })

        }

        binding.btnFindPassword.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(parentContext.binding.container.id, PasswordInputEmailFragment(), "password")
                .commit()
        }

        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.title.text = "로그인"
    }
}