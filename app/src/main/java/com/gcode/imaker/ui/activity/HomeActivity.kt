package com.gcode.imaker.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gcode.imaker.R
import com.gcode.imaker.ui.component.userNameOutlinedTextField
import com.gcode.imaker.ui.fragment.DataFragment
import com.gcode.imaker.ui.fragment.ForumFragment
import com.gcode.imaker.ui.fragment.HomeFragment
import com.gcode.imaker.ui.fragment.ReleaseFragment
import com.gcode.imaker.ui.model.releases
import com.gcode.imaker.ui.theme.bkMain
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.tools.utils.MsgWindowUtils
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            HomeApp(this)
        }
    }
}

@Composable
fun HomeApp(context: Context){

    val list_cursor = listOf(
        BottomNavCursor.Home,BottomNavCursor.Forum,BottomNavCursor.Release,BottomNavCursor.Data
    )

    // 记住选中tab位置
    var selectIndex by remember {
        mutableStateOf(0)
    }

    val navController = rememberNavController()

    ProvideWindowInsets {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
        }

        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color(217,255,214),
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEachIndexed { index, screen ->
                        BottomNavigationItem(
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }

                                selectIndex = index
                            },
                            icon = {
                                when (index) {
                                    selectIndex -> {
                                        Image(
                                            painter = painterResource(id = list_cursor[index].curIcon),
                                            contentDescription = null
                                        )
                                    }
                                    else -> {
                                        Image(
                                            painter = painterResource(id = list_cursor[index].curIcon),
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            label = {
                                Text(
                                    text = stringResource(id = list_cursor[index].curName),
                                    textAlign = TextAlign.Center,
                                    color = if (index == selectIndex)
                                        Color(0xFF0077E6)
                                    else
                                        Color.Black
                                )
                            }
                        )
                    }
                }
            }
        )
        {
            Column(modifier = Modifier.background(Color(217,255,214)).fillMaxSize()) {
                Spacer(modifier = Modifier
                    .statusBarsHeight()
                    .fillMaxWidth())

                NavHost(navController = navController, startDestination = Screen.Home.route){
                    // 首页
                    composable(Screen.Home.route) {

                    }
                    // 论坛
                    composable(Screen.Forum.route) {
                        ForumFragment()
                    }
                    // 发布
                    composable(Screen.Release.route) {
                        ReleaseFragment(releases,navController)
                    }
                    // 数据
                    composable(Screen.Data.route) { DataFragment() }
                }
            }
        }
    }
}

/**
 * 了解更多请参考 https://developer.android.com/jetpack/compose/navigation?hl=zh-cn#bottom-nav
 * @property route String
 * @property resourceId Int
 * @constructor
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.home)
    object Forum : Screen("forum", R.string.forum)
    object Release: Screen("release", R.string.release)
    object Data: Screen("data", R.string.data)
}

val items = listOf(
    Screen.Home,
    Screen.Forum,
    Screen.Release,
    Screen.Data
)

enum class BottomNavCursor(
    @StringRes val curName:Int,
    @DrawableRes val curIcon:Int
){
    Home(R.string.home,R.drawable.ic_home),
    Forum(R.string.forum, R.drawable.ic_forum),
    Release(R.string.release, R.drawable.ic_release),
    Data(R.string.data, R.drawable.ic_data)
}