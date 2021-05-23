package com.junction.jschool.component

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


/**
 *作者:created by HP on 2021/5/23 08:50
 *邮箱:sakurajimamai2020@qq.com
 */
class NoScrollViewPager : ViewPager {
    private var scrollable = true

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context) : super(context) {}

    fun setScrollable(scrollable: Boolean) {
        this.scrollable = scrollable
    }

    fun isScrollable(): Boolean {
        return scrollable
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (scrollable) {
            super.onTouchEvent(ev)
        } else {
            false
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (scrollable) {
            super.onInterceptTouchEvent(ev)
        } else {
            false
        }
    }
}