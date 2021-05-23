package com.junction.jschool.model

import android.graphics.drawable.Drawable
import com.junction.jschool.R
import com.gcode.gutils.adapter.BaseItem

/**
 *作者:created by HP on 2021/5/22 02:13
 *邮箱:sakurajimamai2020@qq.com
 */
class ReleaseModel(val drawable:Drawable?, val title:String):BaseItem{
    override fun getItemBindViewType(): Int {
        return R.layout.release_model_item
    }

    override fun getItemViewType(): Int {
        return -100
    }
}