package com.junction.jschool.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class FragmentAdapter(private val mFragments: List<Fragment>, fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(i: Int): Fragment {
        return mFragments[i]
    }

    override fun getCount(): Int {
        return mFragments.size
    }
}