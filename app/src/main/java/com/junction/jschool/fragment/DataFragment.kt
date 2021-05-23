package com.junction.jschool.fragment

import android.net.http.SslError
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.junction.jschool.R
import com.junction.jschool.adapter.FragmentAdapter
import com.junction.jschool.databinding.FragmentDataBinding


class DataFragment : Fragment() {
    private lateinit var binding:FragmentDataBinding

    //添加主界面Fragment
    private val fragments = ArrayList<Fragment>().apply {
        add(ClassFragment())
        add(PersonFragment())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_data,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FragmentAdapter(fragments, childFragmentManager)
        binding.dataVp.apply{
            this.adapter = adapter

            setScrollable(false)
            /**
             * view_pager滑动事件
             */
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
                override fun onPageSelected(i: Int) {
                    // Selecting a tab at a specific position
                }

                override fun onPageScrollStateChanged(i: Int) {}
            })
        }

        binding.classBtn.setOnClickListener {
            binding.dataVp.currentItem = 0
            binding.classBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
            binding.classBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_blue_background)
            binding.personBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.black))
            binding.personBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_white_background)
        }

        binding.personBtn.setOnClickListener {
            binding.dataVp.currentItem = 1
            binding.personBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
            binding.personBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_blue_background)
            binding.classBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.black))
            binding.classBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_white_background)
        }
    }
}