package com.gcode.imaker.ui.activity;

import android.content.Intent
import android.os.Build
import android.os.Bundle;
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import com.gcode.imaker.ui.component.*
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.ui.theme.bkMain
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class SignUpActivity:AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {

                rememberSystemUiController().setStatusBarColor(
                    Color.Transparent, darkIcons = MaterialTheme.colors.isLight)

                ConstraintLayout(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(bkMain(this))) {

                    val (statusBar,firstColumn,secondColumn) = createRefs()

                    Spacer(modifier = Modifier
                        .statusBarsHeight()
                        .fillMaxWidth()
                        .constrainAs(statusBar) {
                            top.linkTo(parent.top)
                        })

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .constrainAs(firstColumn) {
                            top.linkTo(statusBar.bottom)
                        }) {
                        Text(
                            text = "加入我们，创客！",
                            fontWeight = FontWeight.Light,
                            fontFamily = XiangSuFamily,
                            fontSize = 35.sp,
                            modifier = Modifier
                                .padding(15.dp, 50.dp, 0.dp, 10.dp)
                                .width(IntrinsicSize.Max),
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "请输入你的基本信息",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(15.dp, 5.dp, 15.dp, 0.dp)
                                .fillMaxWidth(),
                            color = Color(0xff535c68),
                            softWrap = true
                        )

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            userNameOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            passWordOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            emailOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            campusOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            qqOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,10.dp)){
                            groupOutlinedTextField()
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .constrainAs(secondColumn) {
                            bottom.linkTo(parent.bottom, margin = 50.dp)
                        }) {
                        SignUpButton(normaBtnColor = Color(0xff0652DD)) {
                            val intent = Intent(this@SignUpActivity.applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }

}