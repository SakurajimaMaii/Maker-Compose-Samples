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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcode.imaker.R
import com.gcode.imaker.ui.theme.LightBlue500

/**
 *作者:created by HP on 2021/9/9 13:37
 *邮箱:sakurajimamai2020@qq.com
 */
class ForumTag(val content: String)

val forumTags = listOf(
    ForumTag("Cpp"),
    ForumTag("Python"),
    ForumTag("Html"),
    ForumTag("Css"),
    ForumTag("Android"),
    ForumTag("Kotlin"),
    ForumTag("Java"),
    ForumTag("Ps"),
    ForumTag("Ae"),
    ForumTag("Pr"),
    ForumTag("3DMax"),
    ForumTag("Ai"),
    ForumTag("Github"),
    ForumTag("Jetpack Compose"),
    ForumTag("OpenCV"),
    ForumTag("Tensorflow"),
    ForumTag("Anaconda")

)

@Composable
fun ForumTagItem(forumTag: ForumTag){

    var selected by remember{
        mutableStateOf(true)
    }

    Box(modifier = Modifier.padding(4.dp)){
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .clickable {
                    selected = !selected
                },
            border = BorderStroke(
                2.dp,
                color = if(selected)
                    Color(0xffb2bec3)
                else
                    colorResource(id = R.color.util_light_sea_blue)
            )
        ){
            Text(
                text = forumTag.content,
                modifier = Modifier.padding(10.dp, 5.dp).width(IntrinsicSize.Min),
                softWrap = false,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun ForumTagTextItem(forumTag: ForumTag){

    var selected by remember{
        mutableStateOf(false)
    }

    Text(
        text = forumTag.content,
        modifier = Modifier
            .padding(0.dp, 5.dp)
            .fillMaxWidth()
            .clickable{
                selected = !selected
            },
        softWrap = false,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = if(selected){
            LightBlue500
        }else{
            MaterialTheme.colors.onPrimary
        }
    )
}

@Preview
@Composable
fun PreviewTag(){
    ForumTagItem(forumTag = forumTags[0])
}