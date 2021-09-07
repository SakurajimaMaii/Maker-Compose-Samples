package com.gcode.imaker.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gcode.imaker.ui.fragment.*

/**
 *作者:created by HP on 2021/9/5 14:22
 *邮箱:sakurajimamai2020@qq.com
 */
class DataFmAdapter(fragment:Fragment):FragmentStateAdapter(fragment) {
    companion object{
        const val num_pages = 2
    }

    private enum class FmIndex{
        Person,Class
    }

    override fun getItemCount(): Int {
        return num_pages
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            FmIndex.Person.ordinal -> PersonFragment()
            FmIndex.Class.ordinal -> ClassFragment()
            else -> HomeFragment()
        }
    }
}