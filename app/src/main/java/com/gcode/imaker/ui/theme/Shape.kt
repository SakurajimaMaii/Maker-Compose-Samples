package com.gcode.imaker.ui.theme

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gcode.tools.utils.ScreenSizeUtils

/**
 *作者:created by HP on 2021/9/5 19:11
 *邮箱:sakurajimamai2020@qq.com
 */
val shapes = Shapes(
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(0f),
    large = RoundedCornerShape(
        topStart = 30.dp,
        topEnd = 0.dp,
        bottomEnd = 0.dp,
        bottomStart = 0.dp
    )
)