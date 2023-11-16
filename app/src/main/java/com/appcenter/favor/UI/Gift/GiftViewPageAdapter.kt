package com.appcenter.favor.UI.Gift

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class GiftViewPageAdapter(manager: FragmentActivity): FragmentStateAdapter(manager) {
    private val fragmentlist : MutableList<Fragment> = arrayListOf()
    private val titleList :MutableList<String> = arrayListOf()



    fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    fun addFragment(fragment: Fragment,title: String){
        fragmentlist.add(fragment)
        titleList.add(title)
    }

    override fun getItemCount(): Int {
        return fragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentlist[position]
    }

}