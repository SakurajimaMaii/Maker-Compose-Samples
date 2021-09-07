package com.gcode.imaker.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.gcode.imaker.R
import com.gcode.imaker.ui.component.SignInButton
import com.gcode.imaker.ui.component.SignUpButton
import com.gcode.imaker.ui.theme.shapes
import com.gcode.imaker.utils.ApplicationUtils


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(shape = shapes.medium) {
                ConstraintLayout(
                    Modifier
                        .background(Color(0xFF0A3180))
                        .fillMaxWidth()
                        .fillMaxHeight()) {
                    val (logo,subTitle,sign) = createRefs()

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null ,
                        modifier = Modifier
                            .constrainAs(logo){
                                top.linkTo(parent.top)
                                absoluteLeft.linkTo(parent.start,margin = 10.dp)
                            }
                            .size(150.dp,80.dp))

                    Text(text = "创新是第一生产力",textAlign = TextAlign.Start,fontSize = 25.sp,fontWeight = FontWeight.Bold,color = colorResource(
                        id = R.color.util_white
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

                        SignInButton {
                            val intent = Intent(ApplicationUtils.context, LoginActivity::class.java).apply {
                                putExtra("userType", "stu")
                            }
                            startActivity(ApplicationUtils.context,intent,null)
                        }

                        SignUpButton {
                            val intent = Intent(ApplicationUtils.context, LoginActivity::class.java).apply {
                                putExtra("userType", "tch")
                            }
                            startActivity(ApplicationUtils.context,intent,null)
                        }
                    }
                }
            }
        }
    }
}