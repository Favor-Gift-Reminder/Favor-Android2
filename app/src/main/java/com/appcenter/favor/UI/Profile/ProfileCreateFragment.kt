package com.appcenter.favor.UI.Profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.appcenter.favor.App
import com.appcenter.favor.Interface.ResponseDTO.userResult
import com.appcenter.favor.MainActivity
import com.appcenter.favor.UserData
import com.appcenter.favor.databinding.FragmentProfileCreateBinding
import com.nise.favor_android.Interface.ResponseDTO.User
import com.nise.favor_android.Login.ProfileMake
import com.nise.favor_android.Repository.userRepository

class ProfileCreateFragment : Fragment() {
    private lateinit var binding: FragmentProfileCreateBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback
    private lateinit var token: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                var repo = userRepository()
                token = App.userData.getAccessToken("Access_Token").toString()
                repo.deleteUser(token, object : userRepository.GetDataCallBack<User>{
                    override fun onSuccess(data: User?) {
                        parentFragmentManager.beginTransaction()
                            .remove(this@ProfileCreateFragment)
                            .commit()
                    }
                    override fun onFailure() {
                    }
                })

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
        binding = FragmentProfileCreateBinding.inflate(inflater, container, false)
        val repo = userRepository()
        binding.btnNext.setOnClickListener {
            val profileForm = ProfileMake(
                binding.name.text.toString().trim(),
                binding.id.text.toString().trim()
            )
            token = App.userData.getAccessToken("Access_Token").toString()
            repo.makeProfileForm(token,profileForm,object :userRepository.GetDataCallBack<userResult>{
                override fun onSuccess(data: userResult?) {
                    parentFragmentManager.beginTransaction()
                        .add(parentContext.binding.container.id, ProfileAgreeFragment())
                        .commit()
                }
                override fun onFailure() {
                }
            })
        }
        init_toolbar()
        binding.root.setOnClickListener{}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }
        binding.toolbar.title.text = "프로필 생성"
    }
}