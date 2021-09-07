package com.gcode.imaker.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gcode.imaker.ui.fragment.DataFragment
import com.gcode.imaker.ui.fragment.ForumFragment
import com.gcode.imaker.ui.fragment.HomeFragment
import com.gcode.imaker.ui.fragment.ReleaseFragment


class MainActFmAdapter(appCompatActivity: AppCompatActivity) :
    FragmentStateAdapter(appCompatActivity) {

    companion object{
        const val num_pages = 4
    }

    private enum class FmIndex{
        Home,Forum,Release,Data
    }

    override fun getItemCount(): Int {
        return num_pages
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            FmIndex.Home.ordinal -> HomeFragment()
            FmIndex.Forum.ordinal -> ForumFragment()
            FmIndex.Release.ordinal -> ReleaseFragment()
            FmIndex.Data.ordinal -> DataFragment()
            else -> HomeFragment()
        }
    }
}