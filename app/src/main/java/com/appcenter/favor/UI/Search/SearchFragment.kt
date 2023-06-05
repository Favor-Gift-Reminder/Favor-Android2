package com.appcenter.favor.UI.Search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.appcenter.favor.MainActivity
import com.appcenter.favor.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private lateinit var parentContext: MainActivity
    private lateinit var onBackPressed: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentContext = context as MainActivity

        onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentContext.supportFragmentManager.beginTransaction()
                    .remove(this@SearchFragment)
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
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        init_toolbar()
        binding.root.setOnClickListener {}
        return binding.root
    }

    private fun init_toolbar() {
        binding.toolbar.back.setOnClickListener { onBackPressed.handleOnBackPressed() }

        binding.toolbar.editSub.setOnClickListener { binding.toolbar.edit.setText("") }

        var inUse = false
        binding.toolbar.edit.addTextChangedListener {
            if (it.toString().isNotBlank()) {
                if(inUse) return@addTextChangedListener
                binding.toolbar.editSub.visibility = View.VISIBLE
                childFragmentManager.beginTransaction()
                    .replace(binding.container.id, SearchRecentFragment())
                    .commit()
            }
            else {
                binding.toolbar.editSub.visibility = View.GONE
                childFragmentManager.beginTransaction()
                    .replace(binding.container.id, SearchMainFragment())
                    .commit()
            }
            inUse = it.toString().isNotBlank()
        }

        binding.toolbar.edit.setOnEditorActionListener { _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (binding.toolbar.edit.text.toString().isBlank()) return@setOnEditorActionListener true
                childFragmentManager.beginTransaction()
                    .replace(binding.container.id, SearchTabFragment())
                    .commit()
                hideKey()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun hideKey() {
        val imm = parentContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(parentContext.currentFocus?.windowToken, 0)
    }
}