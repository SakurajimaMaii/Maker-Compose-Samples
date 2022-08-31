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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcode.imaker.R

/**
 *作者:created by HP on 2021/5/22 20:38
 *邮箱:sakurajimamai2020@qq.com
 */
class Game @JvmOverloads constructor(val name:String,
           val description:String,
           val star:Int,
           @DrawableRes val iconId:Int = R.drawable.ic_game,
           val iconUrl:String = "")

val games = ArrayList<Game>().apply {
    repeat(10){
        add(Game(
            "C语言算法大赛",
            "本次比赛旨在培养你的算法能力,考察内容包括线性表 树 图",
            4,
            R.drawable.ic_game)
        )
    }
}

/**
 * game Item布局
 * @param game Game
 */
@Composable
fun GamesItem(game: Game){
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(game.iconId),
                contentDescription = null,
                modifier = Modifier.size(90.dp,90.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = game.name,
                    fontSize = 20.sp
                )
                Text(
                    text = game.description
                )
            }
        }
    }
}