package com.gcode.imaker.ui.fragment

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gcode.imaker.ui.model.ForumTag
import com.gcode.imaker.ui.model.forumTags
import com.gcode.imaker.ui.theme.XiangSuFamily
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.gcode.imaker.R
import com.gcode.imaker.ui.model.ForumTagTextItem

@ExperimentalAnimationApi
@Composable
fun ForumFragment() {

    var tagVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "选择你感兴趣的话题",
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp, 10.dp, 0.dp, 0.dp),
                fontFamily = XiangSuFamily
            )

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
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 10.dp)
    ){
        items(forumTags){ item->
             ForumTagTextItem(forumTag = item)
        }
    }
}