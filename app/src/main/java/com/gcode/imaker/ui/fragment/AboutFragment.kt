package com.gcode.imaker.ui.fragment

import android.content.Context
import android.os.Build
import android.view.Surface
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gcode.imaker.R
import com.gcode.imaker.ui.activity.items
import com.gcode.imaker.ui.model.CommunicateItem
import com.gcode.imaker.ui.model.communicates
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.ui.theme.bkMain
import com.gcode.imaker.ui.theme.releaseLayoutBk
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.tools.utils.MsgWindowUtils
import com.google.accompanist.coil.rememberCoilPainter

@RequiresApi(Build.VERSION_CODES.R)
@ExperimentalAnimationApi
@Composable
fun AboutFragment(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "关于作者",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = 30.sp,
            modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
            fontFamily = XiangSuFamily
        )

        AuthorsCard(navHostController.context)

        Text(
            text = "联系方式",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = 30.sp,
            modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
            fontFamily = XiangSuFamily
        )

        LazyColumn(
            modifier = Modifier.padding(20.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(communicates){ item->
                CommunicateItem(communicate = item)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun AuthorsCard(context: Context){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(20.dp, 10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .clickable {
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context, "你点什么呢(●'◡'●)")
                }
                .background(releaseLayoutBk(context))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = rememberCoilPainter(
                    request = "https://avatars.githubusercontent.com/u/46998172?v=4"
                ),
                contentDescription = "头像",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(
                        shape = CircleShape,
                        border = BorderStroke(4.dp, SolidColor(colorResource(id = R.color.light_blue)))
                    ).border(
                        shape = CircleShape,
                        border = BorderStroke(4.dp, SolidColor(Color.White))
                    )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "码上夏雨",
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
                Text(
                    text = "SakurajimaMaii",
                    fontSize = 17.sp
                )
            }
        }
    }
}