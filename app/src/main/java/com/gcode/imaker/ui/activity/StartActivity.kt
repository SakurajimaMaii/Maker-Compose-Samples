package com.gcode.imaker.ui.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import com.gcode.imaker.R
import com.gcode.imaker.ui.component.SignInButton
import com.gcode.imaker.ui.component.SignUpButton
import com.gcode.imaker.ui.theme.BkMain
import com.gcode.imaker.ui.theme.shapes
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class StartActivity : AppCompatActivity() {

    private val logTag: String = this.javaClass.simpleName

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            ProvideWindowInsets {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                }

                Surface(shape = shapes.medium) {
                    ConstraintLayout(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(
                                BkMain(this)
                            )) {
                        val (statusBar,logo,subTitle,sign) = createRefs()

                        Spacer(modifier = Modifier
                            .statusBarsHeight()
                            .fillMaxWidth().constrainAs(statusBar){
                                top.linkTo(parent.top)
                            })

                        Image(
                            painter = painterResource(id = R.drawable.logo_black),
                            contentDescription = null ,
                            modifier = Modifier
                                .constrainAs(logo) {
                                    top.linkTo(statusBar.bottom)
                                    absoluteLeft.linkTo(parent.start, margin = 10.dp)
                                }
                                .size(150.dp, 80.dp))

                        Text(text = "创新是第一生产力",textAlign = TextAlign.Start,fontSize = 25.sp,fontWeight = FontWeight.Bold,color = colorResource(
                            id = R.color.util_black
                        ),modifier = Modifier.constrainAs(subTitle){
                            top.linkTo(logo.bottom,5.dp)
                            absoluteLeft.linkTo(parent.start,margin = 10.dp)
                        })

                        Column(modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .fillMaxWidth()
                            .constrainAs(sign) {
                                bottom.linkTo(parent.bottom, margin = 30.dp)
                            }) {

                            SignInButton(normaBtnColor = Color(0xff0652DD)) {
                                val intent = Intent(this@StartActivity.applicationContext, SignInActivity::class.java)
                                try {
                                    this@StartActivity.startActivity(intent,null)
                                }catch (e:ActivityNotFoundException){
                                    Log.e(logTag,"The target activity (SignInAct) is not found",e)
                                }
                            }

                            SignUpButton {
                                val intent = Intent(this@StartActivity.applicationContext, SignUpActivity::class.java)
                                try {
                                    this@StartActivity.startActivity(intent,null)
                                }catch (e:ActivityNotFoundException){
                                    Log.e(logTag,"The target activity (SignUpAct) is not found",e)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}