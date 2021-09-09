package com.gcode.imaker.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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
import androidx.lifecycle.ViewModelProvider
import com.gcode.imaker.ui.component.SignInButton
import com.gcode.imaker.ui.component.passWordOutlinedTextField
import com.gcode.imaker.ui.component.userNameOutlinedTextField
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.gcode.imaker.ui.theme.bkMain
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.imaker.viewModel.TeacherLoginFragmentViewModel
import com.gcode.tools.utils.MsgWindowUtils
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController

//Color(217,255,214),
//Color(171,255,222),
//Color(19,122,252),
//Color(90,0,165),
//Color(64,0,56)

class SignInActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[TeacherLoginFragmentViewModel::class.java]
    }

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
                            text = "欢迎回来，创客！",
                            fontWeight = FontWeight.Light,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .padding(15.dp, 30.dp, 0.dp, 10.dp)
                                .width(IntrinsicSize.Max),
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            fontFamily = XiangSuFamily
                        )

                        Text(
                            text = "不管是继续你的工作，还是查看当前学生的考核情况，亦或者查看实验室的最新动态，总之我们为你提供一切便利",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(15.dp, 0.dp, 15.dp, 20.dp)
                                .fillMaxWidth(),
                            color = Color(0xff535c68),
                            softWrap = true,
                            textAlign = TextAlign.Start
                        )

                        Column(modifier = Modifier.padding(15.dp,20.dp,15.dp,0.dp)){
                            userNameOutlinedTextField()
                        }

                        Column(modifier = Modifier.padding(15.dp,20.dp)){
                            passWordOutlinedTextField()
                        }

                    }



                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .constrainAs(secondColumn) {
                            bottom.linkTo(parent.bottom, margin = 50.dp)
                        }) {
                        SignInButton(normaBtnColor = Color(0xff0652DD)) {
                            val intent = Intent(this@SignInActivity.applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }

        viewModel.loginResult.observe(this){Object->
            val result = Object.getOrNull()
            if (result != null) {
                if(result=="TRUE"){
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆成功")
                    val intent = Intent(ApplicationUtils.context, HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
                }
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
            }
        }
    }
}

