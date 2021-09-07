package com.gcode.imaker.ui.model

import android.graphics.drawable.Drawable
import com.gcode.tools.adapter.BaseUtilItem
import com.gcode.imaker.R

/**
 *作者:created by HP on 2021/5/22 20:38
 *邮箱:sakurajimamai2020@qq.com
 */
class GameModel(val drawable:Drawable?,val name:String,val description:String,val star:Int):
    BaseUtilItem {
    override fun getItemBindViewType(): Int {
        return R.layout.game_model_item
    }

    override fun getItemViewType(): Int {
        return -100
    }
}