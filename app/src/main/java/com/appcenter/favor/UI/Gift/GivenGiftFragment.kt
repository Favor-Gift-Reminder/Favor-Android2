package com.appcenter.favor.UI.Gift

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.appcenter.favor.Interface.ResponseDTO.GiftResult
import com.appcenter.favor.MainActivity
import com.appcenter.favor.R
import com.appcenter.favor.UI.Main.MainFragment
import com.appcenter.favor.databinding.FragmentGiftBinding
import com.appcenter.favor.databinding.FragmentGivenGiftBinding
import com.nise.favor_android.Interface.GiftDTO.GiftRequestDTO
import com.nise.favor_android.Repository.giftRepository


class GivenGiftFragment : Fragment() {
    private lateinit var binding: FragmentGivenGiftBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_given_gift, container, false)
        val giftName = binding.giftName.text

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
                    .add(parentContext.binding.container.id, GiftFriendFragment())
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
            val giftRequest = GiftRequestDTO(
                "a","b", list,binding.btnSelectDate.toString(),"a", giftName.toString(),false,true
            )
        }
    }


}