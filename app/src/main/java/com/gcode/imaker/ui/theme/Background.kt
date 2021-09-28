package com.gcode.imaker.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
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
@Composable
fun bkMain(activity: Activity) = Brush.linearGradient(
    colors = if (!isSystemInDarkTheme())
        listOf(LightBlue100,LightBlue300,LightBlue500,LightBlue700,LightBlue900)
    else
        listOf(BlueGray300, BlueGray500, BlueGray700, BlueGray900),
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
@Composable
fun releaseLayoutBk(activity: Activity) = Brush.linearGradient(
    colors = if (!isSystemInDarkTheme())
        listOf(LightBlue600,LightBlue600)
    else
        listOf(BlueGray300, BlueGray500, BlueGray700, BlueGray900),
    start = Offset(0f, 0f),
    end = Offset(
        ScreenSizeUtils.getMobileScreenWidth(activity).toFloat(),
        ScreenSizeUtils.getMobileScreenHeight(activity).toFloat()
    )
)

