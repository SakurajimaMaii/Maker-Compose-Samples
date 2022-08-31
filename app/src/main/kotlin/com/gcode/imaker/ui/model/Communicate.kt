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

package com.gcode.imaker.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcode.imaker.R
import com.google.accompanist.coil.rememberCoilPainter

/**
 *作者:created by HP on 2021/9/9 15:15
 *邮箱:sakurajimamai2020@qq.com
 */
class Communicate(
    @DrawableRes val communicateIconId:Int,
    val communicateName:String,
    val communicateContent:String
)

val communicates = listOf(
    Communicate(
        R.drawable.ic_github,
        "github",
        "https://github.com/SakurajimaMaii"
    ),
    Communicate(
        R.drawable.ic_twitter,
        "twitter",
        "https://twitter.com/Sakuraj61377782"
    ),
    Communicate(
        R.drawable.ic_csdn,
        "csdn",
        "https://blog.csdn.net/weixin_43699716"
    )
)

@ExperimentalAnimationApi
@Composable
fun CommunicateItem(communicate: Communicate){

    var clickEvent by remember{
        mutableStateOf(false)
    }

    Row(
       modifier = Modifier
           .fillMaxWidth()
           .clickable {
               clickEvent = !clickEvent
           },
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = communicate.communicateIconId),
            contentDescription = null
        )

        Column(
            modifier = Modifier.padding(10.dp, 5.dp)
        ) {
            Text(
                text = communicate.communicateName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colors.onPrimary
            )

            Text(
                text = communicate.communicateContent,
                fontSize = 10.sp,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}