/*
 * MIT License
 *
 * Copyright (c) 2021 码上夏雨
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.gcode.imaker.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcode.imaker.R
import com.gcode.imaker.ui.theme.LightBlue500

/**
 *作者:created by HP on 2021/5/22 06:42
 *邮箱:sakurajimamai2020@qq.com
 */

/**
 * 失物招领模型
 * @property name String 失物名
 * @property description String 失物描述
 * @property tag ArrayList<TagModel> 标签
 * @constructor
 */
data class FindNotice(
    val name: String,
    val description: String,
    val tag: ArrayList<String>,
    @DrawableRes val image: Int
)

val findNotices = listOf(
    FindNotice(
        "平板",
        "在食堂的时候不小心把平板搞丢了,想问一下有没有人捡到我的平板",
        ArrayList<String>().apply {
            add("华为")
        },
        R.drawable.ipad
    ),
    FindNotice(
        "书包",
        "一个蓝色书包,在操场附近丢的",
        ArrayList<String>().apply {
            add("书包")
            add("蓝色")
            add("操场")
        },
        R.drawable.bag
    ),
    FindNotice(
        "耳机",
        "在六号楼211丢了一副耳机,Airpods的,有没有伙伴看见啊",
        ArrayList<String>().apply {
            add("Airpods")
            add("Apple")
            add("耳机")
        },
        R.drawable.earphone
    ), FindNotice(
        "小米手环",
        "操场打球的时候不知道放在那里了,有没有下午2点在操场打球的伙伴看见",
        ArrayList<String>().apply {
            add("小米")
            add("手环")
            add("篮球操场")
        },
        R.drawable.wing
    )
)

/**
 * 寻物启事列表Item布局
 * @param findNotice FindNotice
 */
@Composable
fun FindNoticeItem(findNotice: FindNotice){
    Card(modifier = Modifier.fillMaxWidth().alpha(0.9f),backgroundColor = LightBlue500,shape = RoundedCornerShape(20.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)){
            Text(text = findNotice.name,fontSize = 30.sp,fontWeight = FontWeight.Bold,color = MaterialTheme.colors.onPrimary)

            Text(text = findNotice.description, fontSize = 15.sp,color = MaterialTheme.colors.onPrimary)

            Image(
                painter = painterResource(id = findNotice.image),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp, 150.dp)
                    .wrapContentWidth(Alignment.Start)
            )

            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),horizontalArrangement = Arrangement.spacedBy(10.dp)){
                items(findNotice.tag){ item ->
                    Card(
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.height(30.dp).width(80.dp),
                        border = BorderStroke(width = 2.dp,color = colorResource(id = R.color.util_light_sea_blue)),
                        backgroundColor = Color.White) {
                        Text(
                            text = item,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.wrapContentSize(Alignment.Center))
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(painter = painterResource(R.drawable.ic_eye), contentDescription = null)
                Text(text = "${(0..1000).random()}次浏览",modifier = Modifier.padding(5.dp))
                Icon(painter = painterResource(R.drawable.ic_time), contentDescription = null)
                Text(text = "2021-${(0..9).random()}-${(0..30).random()}",modifier = Modifier.padding(5.dp))
                Icon(painter = painterResource(R.drawable.ic_phone), contentDescription = null)
                Text(text = "${(1000000000..2000000000).random()}",modifier = Modifier.padding(5.dp))
            }
        }
    }
}

@Preview
@Composable
fun findNoticePreview(){
    FindNoticeItem(findNotices[0])
}