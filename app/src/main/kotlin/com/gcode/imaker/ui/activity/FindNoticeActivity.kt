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

package com.gcode.imaker.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.gcode.imaker.ui.model.FindNotice
import com.gcode.imaker.ui.model.FindNoticeItem
import com.gcode.imaker.ui.model.findNotices
import com.gcode.imaker.ui.theme.MakerComposeTheme
import com.gcode.imaker.ui.theme.XiangSuFamily
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class FindNoticeActivity : AppCompatActivity() {
    
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {

        WindowCompat.setDecorFitsSystemWindows(window,false)
        
        super.onCreate(savedInstanceState)

        setContent{
            ProvideWindowInsets{
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(Color.Transparent, darkIcons = false)
                }

                MakerComposeTheme{
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primaryVariant)) {

                        Spacer(modifier = Modifier
                            .statusBarsHeight()
                            .fillMaxWidth())

                        Text(
                            text = "失物信息",
                            fontSize = 30.sp,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(15.dp,20.dp),
                            fontWeight = FontWeight.Light,
                            fontFamily = XiangSuFamily
                        )

                        FindNoticeList(findNotices = findNotices)
                    }
                }
            }
        }
    }
}

@Composable
fun FindNoticeList(findNotices:List<FindNotice>){
    LazyColumn(
        modifier = Modifier.padding(15.dp,0.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ){
        items(findNotices){ item->
            FindNoticeItem(item)
        }
    }
}