package com.gcode.imaker.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gcode.imaker.Constant.ABOUT_PAGE_ROUTE
import com.gcode.imaker.Constant.FORUM_PAGE_ROUTE
import com.gcode.imaker.Constant.HOME_PAGE_ROUTE
import com.gcode.imaker.Constant.RELEASE_PAGE_ROUTE
import com.gcode.imaker.R
import com.gcode.imaker.ui.HomeActNavGraph
import com.gcode.imaker.ui.activity.HomeApp
import com.gcode.imaker.ui.theme.*
import com.google.accompanist.insets.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class HomeActivity : AppCompatActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MakerComposeTheme{
                HomeApp(this,ViewModelProvider(this)[HomeViewModel::class.java])
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun HomeApp(activity: Activity,vm:HomeViewModel) {

    val navController = rememberNavController()
    
    ProvideWindowInsets {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
        }

        Scaffold(
            topBar = { HomeTopBar(vm) },
            bottomBar = { HomeBottomNav(navHostController = navController,vm = vm) }
        )
        { innerContentPadding ->
            HomeContent(innerContentPadding = innerContentPadding, navController = navController, activity = activity)
        }
    }
}

@Composable
fun HomeTopBar(vm:HomeViewModel){

    // 记住选中tab位置
    val selectIndex by vm.currentPageIndex.observeAsState(0)
    
    com.google.accompanist.insets.ui.TopAppBar(
        title = {
            Text(
                text = when(selectIndex) {
                    0 -> "主页"
                    1 -> "选择你感兴趣的话题"
                    2 -> "选择你要发布的信息种类"
                    3 -> "作者信息"
                    else -> "你好，创客"
                },
                fontSize = 20.sp,
                modifier = Modifier.padding(titleStartDimen, 0.dp, 0.dp, 0.dp),
                fontWeight = FontWeight.Light,
                fontFamily = XiangSuFamily
            )
        },
        navigationIcon =  { Image(painter = painterResource(R.drawable.logo_black), contentDescription = null) },
        contentPadding = rememberInsetsPaddingValues(insets = LocalWindowInsets.current.statusBars,additionalStart = 10.dp),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}

/**
 * Home bottom nav
 * 主界面底部导航栏
 * @param navHostController
 */
@Composable
fun HomeBottomNav(
    navHostController: NavHostController,
    vm:HomeViewModel
){
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.navigationBarsPadding()
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEachIndexed { index, screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                    vm.setCurrentPageIndex(index)
                },
                icon = {
                    Image(
                        painter = painterResource(id = screen.iconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.resourceId),
                        textAlign = TextAlign.Center,
                        color = if (index == vm.currentPageIndex.value)
                            Color(0xFF0077E6)
                        else
                            Color.Black
                    )
                }
            )
        }
    }
}

/**
 * Home content
 * 主界面内容
 * @param innerContentPadding
 * @param navController
 * @param activity
 */
@ExperimentalAnimationApi
@Composable
fun HomeContent(
    innerContentPadding:PaddingValues,
    navController:NavHostController,
    activity:Activity
){
    HomeActNavGraph(
        navController = navController,
        startDestination = Screen.Home.route,
        activity,
        modifier = Modifier
            .padding(innerContentPadding)
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxSize()
    )
}

class HomeViewModel: ViewModel(){
    private val _currentPageIndex = MutableLiveData<Int>(0)
    val currentPageIndex: LiveData<Int> = _currentPageIndex

    fun setCurrentPageIndex(index: Int){
        _currentPageIndex.postValue(index)
    }
}

/**
 * 了解更多请参考 https://developer.android.com/jetpack/compose/navigation?hl=zh-cn#bottom-nav
 * @property route String
 * @property resourceId Int
 * @constructor
 */
sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : Screen(HOME_PAGE_ROUTE, R.string.home, R.drawable.ic_home)
    object Forum : Screen(FORUM_PAGE_ROUTE, R.string.forum, R.drawable.ic_forum)
    object Release : Screen(RELEASE_PAGE_ROUTE, R.string.release, R.drawable.ic_release)
    object About : Screen(ABOUT_PAGE_ROUTE, R.string.about, R.drawable.ic_about)
}

val items = listOf(
    Screen.Home,
    Screen.Forum,
    Screen.Release,
    Screen.About
)