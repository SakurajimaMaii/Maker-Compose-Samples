package com.gcode.imaker.ui.model

import android.graphics.drawable.Drawable
import com.gcode.imaker.R
import com.gcode.tools.adapter.BaseUtilItem

/**
 *作者:created by HP on 2021/5/22 02:13
 *邮箱:sakurajimamai2020@qq.com
 */
class ReleaseModel(val drawable:Drawable?, val title:String):BaseUtilItem{
    override fun getItemBindViewType(): Int {
        return R.layout.release_model_item
    }

    override fun getItemViewType(): Int {
        return -100
    }
}