package com.gcode.imaker.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
                fontSize = 20.sp
            )

            AnimatedVisibility(visible = clickEvent) {
                Text(
                    text = communicate.communicateContent,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.End)
                        .weight(1f)
                )
            }
        }
    }
}