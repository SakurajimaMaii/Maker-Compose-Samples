package com.gcode.imaker.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.gcode.imaker.R
import com.gcode.imaker.ui.component.UpImageText
import com.gcode.imaker.ui.model.GamesItem
import com.gcode.imaker.ui.model.games
import com.gcode.imaker.ui.theme.GradientProOne
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent{
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                }

                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(GradientProOne.color_3)) {

                    Spacer(modifier = Modifier
                        .statusBarsHeight()
                        .fillMaxWidth())

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .padding(20.dp, 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier
                            .wrapContentWidth(Alignment.Start)
                            .weight(1f)) {
                            Text(
                                text = "欢迎",
                                fontSize = 30.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Light,
                                fontFamily = XiangSuFamily
                            )
                            Text(
                                text = "快来看看今天的竞赛活动",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Light,
                                fontFamily = XiangSuFamily
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .wrapContentWidth(Alignment.End),
                        )
                    }

                    var gameName by remember {
                        mutableStateOf("")
                    }

                    OutlinedTextField(value = gameName,
                        onValueChange = { gameName = it },
                        label = { Text(text = "输入你要查询的比赛") },
                        shape = RoundedCornerShape(20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = GradientProOne.color_1,
                            unfocusedBorderColor = Color.White,
                            focusedLabelColor = GradientProOne.color_1,
                            unfocusedLabelColor = Color.White,
                            cursorColor = GradientProOne.color_1
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp, 20.dp, 30.dp)
                    )

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        shape = RoundedCornerShape(20.dp,20.dp,0.dp,0.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .padding(10.dp, 10.dp)){
                                UpImageText(Modifier.weight(1f),imageId = R.drawable.ic_sports_competition, text = "体育比赛")
                                UpImageText(Modifier.weight(1f),imageId = R.drawable.ic_answer_contest, text = "答题竞赛")
                                UpImageText(Modifier.weight(1f),imageId = R.drawable.ic_multiplayer_pk, text = "多人pk")
                                UpImageText(Modifier.weight(1f),imageId = R.drawable.ic_leader_board, text = "排行榜")
                            }

                            LazyColumn(modifier = Modifier.fillMaxWidth()){
                                items(games){ item ->
                                    GamesItem(game = item)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}