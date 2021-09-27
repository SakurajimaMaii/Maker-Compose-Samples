package com.gcode.imaker.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gcode.imaker.ui.activity.FindNoticeActivity
import com.gcode.imaker.ui.activity.GameActivity
import com.gcode.imaker.ui.model.Release
import com.gcode.imaker.ui.model.ReleaseItem
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.tools.utils.MsgWindowUtils

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ReleaseFragment(releases: List<Release>, navController: NavController, activity: Activity) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "选择你要发布的信息种类",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            fontSize = 30.sp,
            modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
            fontFamily = XiangSuFamily
        )

        Text(
            text = "目前提供以下集中信息类型",
            color = Color.Gray,
            fontSize = 15.sp,
            modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 15.dp),
            fontWeight = FontWeight.Bold
        )

        ReleaseItems(releases, navController, activity)
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ReleaseItems(releases: List<Release>, navController: NavController ,activity: Activity) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp ,0.dp ,0.dp),
        contentPadding = PaddingValues(vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(releases) { index,item ->
            ReleaseItem(
                index,
                release = item,
                activity = activity,
                clickEvent = { ReleaseItemClickEvent(item,navController) }
            )
        }
    }
}

/**
 * ReleaseItem点击事件
 */
val ReleaseItemClickEvent = { release: Release,navController:NavController ->
    when (release) {
        Release.Competition -> {
            val intent = Intent(navController.context, GameActivity::class.java)
            navController.context.startActivity(intent)
        }
        Release.FindNotice -> {
            val intent = Intent(navController.context, FindNoticeActivity::class.java)
            navController.context.startActivity(intent)
        }
        else ->
            MsgWindowUtils.showShortMsg(ApplicationUtils.context, release.title)
    }
}