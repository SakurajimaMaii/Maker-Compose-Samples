package com.gcode.imaker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 *作者:created by HP on 2021/9/5 20:07
 *邮箱:sakurajimamai2020@qq.com
 */
@Composable
fun BaseSignButton(
    normalText:String,
    pressedText:String,
    normalTextColor:Color,
    pressedTextColor:Color,
    normaBtnColor:Color,
    pressedBtnColor:Color,
    click: () -> Unit
) {

    //按钮的状态
    val interactionSource = remember { MutableInteractionSource() }

    val (text, textColor, buttonColor) = when {
        interactionSource.collectIsPressedAsState().value -> ButtonState(pressedText, pressedTextColor, pressedBtnColor)
        else -> ButtonState( normalText,normalTextColor, normaBtnColor)
    }

    Button(
        onClick = click,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth().padding(15.dp,0.dp,15.dp,10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor,contentColor = textColor)
    ) {
        Column(modifier = Modifier.background(Color.Transparent)){
            Text(text = text,fontWeight = FontWeight.Bold,fontSize = 18.sp,fontFamily = FontFamily.SansSerif)
        }
    }
}



@Composable
fun SignInButton(normalTextColor: Color = Color.White,
                 pressedTextColor: Color = Color.White,
                 normaBtnColor: Color = Color(0xFF3498db),
                 pressedBtnColor: Color = Color(0xFF2980b9),
                 click: () -> Unit){
    BaseSignButton(
        normalText = "登录",
        pressedText = "登录",
        normalTextColor = normalTextColor,
        pressedTextColor = pressedTextColor,
        normaBtnColor = normaBtnColor,
        pressedBtnColor = pressedBtnColor,
        click = click
    )
}

@Composable
fun SignUpButton(normalTextColor: Color = Color.White,
                 pressedTextColor: Color = Color.White,
                 normaBtnColor: Color = Color(0xFF3498db),
                 pressedBtnColor: Color = Color(0xFF2980b9),
                 click: () -> Unit){
    BaseSignButton(
        normalText = "注册",
        pressedText = "注册",
        normalTextColor = normalTextColor,
        pressedTextColor = pressedTextColor,
        normaBtnColor = normaBtnColor,
        pressedBtnColor = pressedBtnColor,
        click = click
    )
}

data class ButtonState(var text: String, var textColor: Color, var buttonColor: Color)