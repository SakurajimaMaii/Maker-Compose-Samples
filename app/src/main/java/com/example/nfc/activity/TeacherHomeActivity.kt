package com.example.nfc.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.nfc.R
import com.example.nfc.adapter.FragmentAdapter
import com.example.nfc.databinding.ActivityTeacherHomeBinding
import com.example.nfc.fragment.TeacherHomeFragment
import com.example.nfc.fragment.SettingFragment
import nl.joery.animatedbottombar.AnimatedBottomBar


class TeacherHomeActivity : BaseActivity() {
    private lateinit var binding: ActivityTeacherHomeBinding

    //添加主界面Fragment
    private val fragments = ArrayList<Fragment>().apply {
        add(TeacherHomeFragment())
        //add(SettingFragment())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_home)

        initUI()

        val adapter = FragmentAdapter(fragments, supportFragmentManager)
        binding.viewPager.apply{
            this.adapter = adapter
            /**
             * view_pager滑动事件
             */
            addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
                override fun onPageSelected(i: Int) {
                    // Selecting a tab at a specific position
                    binding.bottomNavView.selectTabAt(i)
                }

                override fun onPageScrollStateChanged(i: Int) {}
            })
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
            setCheckedItem(R.id.navMail)
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