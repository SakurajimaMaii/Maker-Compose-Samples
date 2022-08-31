/*
 * MIT License
 *
 * Copyright (c) 2021 码上夏雨
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

