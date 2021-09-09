package com.gcode.imaker.ui.fragment

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.gcode.imaker.ui.model.Project
import com.gcode.imaker.ui.model.ProjectItem
import com.gcode.imaker.ui.model.projects
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.ui.theme.titleStartDimen
import com.gcode.imaker.ui.theme.titleTopDimen
import androidx.compose.foundation.layout.Spacer as Spacer

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeFragment(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "你好，创客",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(titleStartDimen, titleTopDimen, 0.dp, 0.dp),
            fontWeight = FontWeight.Light,
            fontFamily = XiangSuFamily
        )

        Text(
            text = "从以下项目开始你的创客之旅",
            color = Color.Gray,
            fontSize = 20.sp,
            modifier = Modifier.padding(titleStartDimen, titleTopDimen, 0.dp, 15.dp)
        )

        ProjectItems(projects = projects,navHostController)
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ProjectItems(projects:List<Project>,navHostController:NavController){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(projects){ item->
                ProjectItem(item,navHostController)
            }
        }
    }
}