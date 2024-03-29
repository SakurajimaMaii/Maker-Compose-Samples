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

package com.gcode.imaker.ui

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gcode.imaker.ui.activity.Screen
import com.gcode.imaker.ui.fragment.AboutFragment
import com.gcode.imaker.ui.fragment.ForumFragment
import com.gcode.imaker.ui.fragment.HomeFragment
import com.gcode.imaker.ui.fragment.ReleaseFragment
import com.gcode.imaker.ui.model.releases

/**
 *作者:created by HP on 2021/9/9 13:06
 *邮箱:sakurajimamai2020@qq.com
 */
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeActNavGraph(
    navController: NavHostController,
    startDestination: String,
    activity: Activity,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = startDestination,modifier = modifier){
        // 首页
        composable(Screen.Home.route) {
            HomeFragment(activity)
        }
        // 论坛
        composable(Screen.Forum.route) {
            ForumFragment()
        }
        // 发布
        composable(Screen.Release.route) {
            ReleaseFragment(releases,navController,activity)
        }
        // 数据
        composable(Screen.About.route) {
            AboutFragment(activity)
        }
    }
}