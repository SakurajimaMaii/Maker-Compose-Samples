package com.gcode.imaker.ui.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gcode.imaker.R
import com.gcode.imaker.ui.theme.bkMain
import com.gcode.imaker.ui.theme.releaseLayoutBk
import com.google.accompanist.coil.rememberCoilPainter

/**
 *作者:created by HP on 2021/9/9 19:05
 *邮箱:sakurajimamai2020@qq.com
 */
class Project(
    val author: String,
    val proImgUrl:String,
    val like:Int,
    val see:Int
)

val projects = listOf(
    Project(
        "Yentech Logo Design: Letter Y + Connection",
        "https://cdn.dribbble.com/users/4495554/screenshots/15926480/media/c71f00bf1cc0a07d1be14a3a694aedb9.jpg",
        176,334
    ),
    Project(
        "Peakforce",
        "https://cdn.dribbble.com/users/1769954/screenshots/16302881/media/3b541e49c513769522885164aa4f303d.png",
        171,283
    ),
    Project(
        "Turbine",
        "https://cdn.dribbble.com/users/1769954/screenshots/12293701/media/3c899d83bf4148084a8de111d50b8e91.png",
        444,124
    ),
    Project(
        "Modern X Letter Mark Software Company Logo",
        "https://cdn.dribbble.com/users/5706294/screenshots/16345634/media/ae837087326fb39248f692fc465d1dae.jpg",
        132,135
    ),
    Project(
        "Playhub Logo Concept",
        "https://cdn.dribbble.com/users/1139587/screenshots/15803649/media/3da6fab4e42413753475828d47eef668.png",
        325,739
    ),
)

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ProjectItem(project: Project,navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(releaseLayoutBk(navController.context))
    ) {
        Image(
            painter = rememberCoilPainter(
                request = project.proImgUrl,
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ){
            Text(
                text = project.author,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
                    .padding(10.dp,5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(10.dp,0.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(R.drawable.ic_like), contentDescription = null)
                Text(text = project.like.toString(),modifier = Modifier.padding(5.dp))
                Icon(painter = painterResource(R.drawable.ic_eye), contentDescription = null)
                Text(text = project.see.toString(),modifier = Modifier.padding(5.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview
@Composable
fun PreviewProItem(){

}