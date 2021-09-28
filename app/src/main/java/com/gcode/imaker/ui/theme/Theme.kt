package com.gcode.imaker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//关于MaterialTheme颜色设计规范参考下面的链接
//https://material.io/design/color/the-color-system.html#color-usage-and-palettes

/**
 *作者:created by HP on 2021/9/8 10:56
 *邮箱:sakurajimamai2020@qq.com
 */
@Composable
fun MakerComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors, // 颜色
        typography = MaterialTheme.typography, // 字体
        shapes = MaterialTheme.shapes, // 形状
        content = content // 声明的视图
    )
}

/**
 * Dark color palette
 */
private val DarkColorPalette = darkColors(
    primary = BlueGray500,
    primaryVariant = BlueGray800,
    secondary = BlueGray100,
    onPrimary = Color.White
)

/**
 * Light color palette
 */
private val LightColorPalette = lightColors(
    primary = LightBlue500,
    primaryVariant = LightBlue200,
    secondary = Color(0xFF0652DD),
    onPrimary = Color.Black
)