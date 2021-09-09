package com.gcode.imaker.ui.theme

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.gcode.tools.utils.ScreenSizeUtils

/**
 *作者:created by HP on 2021/9/8 21:18
 *邮箱:sakurajimamai2020@qq.com
 */


/**
 * 主要背景图
 * @param context Context
 * @return Brush
 */
@RequiresApi(Build.VERSION_CODES.R)
fun bkMain(context: Context) = Brush.linearGradient(
    colors = listOf(
        Color(217,255,214),
        Color(171,255,222),
        Color(19,122,252)
    ),
    start = Offset(0f, 0f),
    end = Offset(
        ScreenSizeUtils.getMobileScreenWidth(context).toFloat(),
        ScreenSizeUtils.getMobileScreenHeight(context).toFloat()
    )
)

/**
 * Release item 背景图
 * @param navController NavController
 * @return Brush
 */
@RequiresApi(Build.VERSION_CODES.R)
fun releaseLayoutBk(navController: NavController) = Brush.linearGradient(
    colors = listOf(
        GradientProOne.color_2,
        GradientProOne.color_3,
        GradientProOne.color_4,
    ),
    start = Offset(0f, 0f),
    end = Offset(
        ScreenSizeUtils.getMobileScreenWidth(navController.context).toFloat(),
        ScreenSizeUtils.getMobileScreenHeight(navController.context).toFloat()
    )
)