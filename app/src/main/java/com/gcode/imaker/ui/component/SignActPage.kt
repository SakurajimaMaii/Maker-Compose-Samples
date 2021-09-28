package com.gcode.imaker.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 *作者:created by HP on 2021/9/7 19:37
 *邮箱:sakurajimamai2020@qq.com
 */

/**
 * 用户名输入栏
 * @return String
 */
@Composable
fun userNameOutlinedTextField():String{
    var userName by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = userName,
        onValueChange = { userName = it },
        label = {
            Text(
                text = if(userName == ""){
                    "请输入你的用户名"
                }
                else{
                    "你好,$userName!"
                },
                color = MaterialTheme.colors.onPrimary
            ) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return userName
}

/**
 * 密码输入栏
 * @return String
 */
@Composable
fun passWordOutlinedTextField():String{
    var passWord by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = passWord,
        onValueChange = { passWord = it },
        label = { Text("请输入密码",color = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return passWord
}

@Composable
fun emailOutlinedTextField():String{
    var email by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("请输入邮箱",color = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return email
}

@Composable
fun campusOutlinedTextField():String{
    var campus by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = campus,
        onValueChange = { campus = it },
        label = { Text("请输入校区",color = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return campus
}

@Composable
fun qqOutlinedTextField():String{
    var qq by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = qq,
        onValueChange = { qq = it },
        label = { Text("请输入qq号",color = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return qq
}

@Composable
fun groupOutlinedTextField():String{
    var group by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = group,
        onValueChange = { group = it },
        label = { Text("请输入组别",color = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        colors = textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary
        )
    )

    return group
}

@Preview
@Composable
fun preview(){
    userNameOutlinedTextField()
}