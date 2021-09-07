package com.gcode.imaker.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.gcode.imaker.R
import com.gcode.imaker.ui.adapter.MainActFmAdapter
import com.gcode.imaker.databinding.ActivityHomeBinding
import nl.joery.animatedbottombar.AnimatedBottomBar


class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        initUI()

        val adapter = MainActFmAdapter(this)
        //设置主界面ViewPager2
        binding.viewPager.apply{
            this.adapter = adapter
            isUserInputEnabled = false
            offscreenPageLimit = 1
        }

        /**
         * 底部导航栏点击事件
         */
        binding.bottomNavView.setOnTabSelectListener(object :
            AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                binding.viewPager.currentItem = newIndex
            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                binding.viewPager.currentItem = index
            }
        })
    }

    private fun initUI() {
        //设置顶部栏
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.mipmap.title_bar)
        }

        //默认选中Mail
        binding.sidebarView.apply {
            setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.navExit -> {
                        binding.drawerLayout.closeDrawers()
                    }
                }
                true
            }
        }
    }

    @SuppressLint("InflateParams")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //打开侧边栏
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return true
    }
}