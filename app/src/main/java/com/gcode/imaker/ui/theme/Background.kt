package com.gcode.imaker.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.gcode.tools.utils.ScreenSizeUtils

/**
 *作者:created by HP on 2021/9/8 21:18
 *邮箱:sakurajimamai2020@qq.com
 */


/**
 * Bk main
 * 主要背景图
 * @param activity
 */
@RequiresApi(Build.VERSION_CODES.R)
fun bkMain(activity: Activity) = Brush.linearGradient(
    colors = listOf(
        Color(217,255,214),
        Color(171,255,222),
        Color(19,122,252)
    ),
    start = Offset(0f, 0f),
    end = Offset(
        ScreenSizeUtils.getMobileScreenWidth(activity).toFloat(),
        ScreenSizeUtils.getMobileScreenHeight(activity).toFloat()
    )
)

/**
 * Release layout bk
 * Release item主要背景图
 * @param activity
 */
@RequiresApi(Build.VERSION_CODES.R)
fun releaseLayoutBk(activity: Activity) = Brush.linearGradient(
    colors = listOf(
        GradientProOne.color_2,
        GradientProOne.color_3,
        GradientProOne.color_4,
    ),
    start = Offset(0f, 0f),
    end = Offset(
        ScreenSizeUtils.getMobileScreenWidth(activity).toFloat(),
        ScreenSizeUtils.getMobileScreenHeight(activity).toFloat()
    )
)