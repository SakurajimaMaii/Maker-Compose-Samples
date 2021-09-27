package com.gcode.imaker.ui.model

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.gcode.imaker.R
import com.gcode.imaker.ui.theme.releaseLayoutBk
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.tools.adapter.BaseUtilItem
import com.google.accompanist.coil.rememberCoilPainter

/**
 *作者:created by HP on 2021/5/22 02:13
 *邮箱:sakurajimamai2020@qq.com
 */
/**
 * 发布信息种类
 * @property drawableUrl String
 * @property title String
 * @constructor
 */
//https://www.iconfont.cn/illustrations/detail?spm=a313x.7781069.1998910419.d9df05512&cid=25362
enum class Release(val drawableUrl:String, var title:String){
    Competition("https://iconfont.alicdn.com/t/bf1bff48-81b2-4c0b-9a2c-5181b240e1cf.png", "竞赛咨询(Competition consulting)"),
    Member("https://iconfont.alicdn.com/t/0ef9fc84-0c82-4158-abbf-afe02c2222e5.png","成员联系(Member contact)"),
    Mission("https://iconfont.alicdn.com/t/72628fed-448e-46a7-864b-f21bd3ab5e12.png","任务完成情况(Mission completion)"),
    Office("https://iconfont.alicdn.com/t/7a1476d4-de66-48c8-9fb7-ac49db09e53f.png","办公信息(Office information)"),
    Latest("https://iconfont.alicdn.com/t/f0d0d295-4871-47ed-91f9-baacbd1ec538.png","最新文件(Latest file)"),
    FindNotice("https://iconfont.alicdn.com/t/b83b68f7-2c0a-4c2c-a2cf-5b6d9c2efb3b.png","失物招领(Find notice)")
}

/**
 * 信息种类集合
 */
val releases = listOf(Release.Competition,Release.Member,Release.Mission,Release.Office,Release.Latest,Release.FindNotice)

/**
 * ReleaseItem列表内布局
 * @param release Release
 * @param navController NavController
 * @param clickEvent Function0<Unit> Item点击事件
 */
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ReleaseItem(index:Int, release: Release, activity: Activity, clickEvent: () -> Unit) {

    Row {
        if (index % 2 != 0){
            Spacer(modifier = Modifier.width(40.dp))
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = clickEvent
                ),
            shape = RoundedCornerShape(30.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .background(brush = releaseLayoutBk(activity)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberCoilPainter(request = release.drawableUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .width(80.dp),
                )
                ConstraintLayout(
                    modifier = Modifier
                        .padding(10.dp, 5.dp)
                        .height(90.dp)
                ) {

                    val (title, subTitle, icon) = createRefs()

                    Text(
                        text = release.title,
                        fontSize = 18.sp,
                        modifier = Modifier.constrainAs(title) {
                            top.linkTo(parent.top)
                            absoluteLeft.linkTo(parent.absoluteLeft)
                        },
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "了解更多",
                        fontSize = 12.sp,
                        modifier = Modifier.constrainAs(subTitle) {
                            top.linkTo(title.bottom, margin = 25.dp)
                            bottom.linkTo(parent.bottom)
                            absoluteLeft.linkTo(parent.absoluteLeft)
                        },
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_link),
                        contentDescription = null,
                        modifier = Modifier.constrainAs(icon) {
                            top.linkTo(subTitle.top)
                            absoluteLeft.linkTo(subTitle.absoluteRight)
                            bottom.linkTo(subTitle.bottom)
                        }
                    )
                }
            }
        }
    }
}