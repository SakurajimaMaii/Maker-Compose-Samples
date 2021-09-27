package com.gcode.imaker.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.gcode.imaker.ui.model.FindNotice
import com.gcode.imaker.ui.model.FindNoticeItem
import com.gcode.imaker.ui.model.findNotices
import com.gcode.imaker.ui.theme.GradientProOne
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.ui.theme.bkMain
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class FindNoticeActivity : AppCompatActivity() {
    
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window,false)
        
        super.onCreate(savedInstanceState)

        setContent{
            ProvideWindowInsets{
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                }
                
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(GradientProOne.color_3)) {

                    Spacer(modifier = Modifier
                        .statusBarsHeight()
                        .fillMaxWidth())

                    Text(
                        text = "失物信息",
                        fontSize = 30.sp,
                        color = Color.White,
                        modifier = Modifier.padding(15.dp,20.dp),
                        fontWeight = FontWeight.Light,
                        fontFamily = XiangSuFamily
                    )

                    FindNoticeList(findNotices = findNotices)
                }
            }
        }
    }
}

@Composable
fun FindNoticeList(findNotices:List<FindNotice>){
    LazyColumn(
        modifier = Modifier.padding(15.dp,0.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(findNotices){ item->
            FindNoticeItem(item)
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}