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
import com.gcode.imaker.ui.theme.MakerComposeTheme
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.tools.utils.MsgWindowUtils

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ReleaseFragment(releases: List<Release>, navController: NavController, activity: Activity) {
    MakerComposeTheme {
        ReleaseItems(releases, navController, activity)
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ReleaseItems(releases: List<Release>, navController: NavController ,activity: Activity) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp, 0.dp, 0.dp),
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