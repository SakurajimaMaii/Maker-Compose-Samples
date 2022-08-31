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

package com.gcode.imaker.ui.fragment

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gcode.imaker.R
import com.gcode.imaker.ui.model.ForumTag
import com.gcode.imaker.ui.model.ForumTagTextItem
import com.gcode.imaker.ui.model.forumTags
import com.gcode.imaker.ui.theme.MakerComposeTheme

@ExperimentalAnimationApi
@Composable
fun ForumFragment() {

    var tagVisible by remember {
        mutableStateOf(false)
    }
    MakerComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                ForumTags(forumTags = forumTags)
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){

                val (fab) = createRefs()

                FloatingActionButton(
                    onClick = {
                        tagVisible = !tagVisible
                    },
                    modifier = Modifier
                        .wrapContentSize(Alignment.BottomEnd)
                        .constrainAs(fab) {
                            end.linkTo(parent.end, margin = 20.dp)
                            bottom.linkTo(parent.bottom, margin = 80.dp)
                        }
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun ForumTags(forumTags:List<ForumTag>){
//    StaggeredGrid(
//        modifier = Modifier
//            .horizontalScroll(rememberScrollState())
//            .padding(horizontal = 20.dp, vertical = 10.dp)
//    ) {
//        forumTags.forEach { forumTag ->
//            ForumTagItem(forumTag = forumTag)
//        }
//    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 0.dp)
    ){
        items(forumTags){ item->
             ForumTagTextItem(forumTag = item)
        }
    }
}