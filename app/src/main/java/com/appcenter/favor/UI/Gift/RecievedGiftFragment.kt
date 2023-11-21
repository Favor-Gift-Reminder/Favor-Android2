package com.appcenter.favor.UI.Gift

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.databinding.FragmentGivenGiftBinding
import com.appcenter.favor.databinding.FragmentRecievedGiftBinding
import com.nise.favor_android.Interface.GiftDTO.GiftRequestDTO


class RecievedGiftFragment : Fragment() {
    private lateinit var binding: FragmentRecievedGiftBinding
    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity
        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .remove(this@RecievedGiftFragment)
                    .commit()
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressed)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecievedGiftBinding.inflate(inflater,container,false)

        binding.apply {
            btnSelectFriend.setOnClickListener {
                val giftFriendFragment = GiftFriendFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager
                supportFragmentManager.setFragmentResultListener(
                    "REQUEST",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST") {
                        val friend = bundle.getString("SELECT_FRIEND")
                        binding.btnSelectFriend.text = friend
                        binding.btnSelectFriend.setTextColor(
                            ContextCompat.getColor(
                                requireActivity(),
                                R.color.icon
                            )
                        )
                    }
                }
                parentFragmentManager.beginTransaction()
                    .add(R.id.container,giftFriendFragment)
                    .commit()
            }

            btnSelectDate.setOnClickListener {
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager
                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        binding.btnSelectDate.text = date
                        binding.btnSelectDate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.icon))
                    }
                }
                // show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
            val list = MutableList<Int>(3, {i -> i})

        }
        return binding.root
    }


}