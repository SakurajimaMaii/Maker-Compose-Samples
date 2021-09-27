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