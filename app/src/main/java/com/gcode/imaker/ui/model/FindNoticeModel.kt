package com.gcode.imaker.ui.model

import android.graphics.drawable.Drawable

/**
 *作者:created by HP on 2021/5/22 06:42
 *邮箱:sakurajimamai2020@qq.com
 */
/**
 * 失物招领模型
 * @property name String 失物名
 * @property description String 失物描述
 * @property tag ArrayList<TagModel> 标签
 * @constructor
 */
data class FindNoticeModel(val name:String,val description:String,val tag:ArrayList<String>,val image: Drawable?)
