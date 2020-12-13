package com.example.nfc.utils

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.LinearLayout

/**
 * 字体设置单例类
 */
object MyViewUtils{
    /**
     * @param valueString String
     * @param unitString String
     * @return SpannableStringBuilder?
     */
    fun setBottomAlignment(valueString: String, unitString: String): SpannableStringBuilder? {
        val spanString = SpannableStringBuilder(valueString + unitString)
        //绝对尺寸
        val absoluteSizeSpan = AbsoluteSizeSpan(60)
        spanString.setSpan(
            absoluteSizeSpan,
            valueString.length,
            spanString.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        // 字体颜色
        val colorSpan = ForegroundColorSpan(Color.BLACK)
        spanString.setSpan(
            colorSpan,
            valueString.length,
            spanString.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        // 字体加粗
        val styleSpan = StyleSpan(Typeface.BOLD)
        spanString.setSpan(styleSpan, 0, valueString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spanString
    }

    /**
     * 根布局需要是LinearLayout
     * @param left Int
     * @param top Int
     * @param right Int
     * @param bottom Int
     * @return LinearLayout.LayoutParams
     */
    fun setTextViewMargin(left:Int,top:Int,right:Int,bottom:Int):LinearLayout.LayoutParams{
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(left, top, right, bottom)
        return params
    }

}