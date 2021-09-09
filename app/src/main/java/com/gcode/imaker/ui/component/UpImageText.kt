package com.gcode.imaker.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 *作者:created by HP on 2021/9/9 10:45
 *邮箱:sakurajimamai2020@qq.com
 */
@Composable
fun UpImageText(
    modifier:Modifier,
    @DrawableRes imageId:Int,
    text:String
){
    Column(
        modifier = modifier.height(IntrinsicSize.Min).width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,modifier = Modifier.size(60.dp,60.dp)
        )

        Text(text = text)
    }
}