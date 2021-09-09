package com.gcode.imaker.ui.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.gcode.imaker.ui.theme.GradientProOne

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
            GradientProOne.color_3
        }else{
            Color(0xff353b48)
        }
    )
}

@Preview
@Composable
fun PreviewTag(){
    ForumTagItem(forumTag = forumTags[0])
}