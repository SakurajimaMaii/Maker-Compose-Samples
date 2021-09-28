package com.gcode.imaker.ui.fragment

import android.app.Activity
import android.os.Build
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.gcode.imaker.ui.model.Project
import com.gcode.imaker.ui.model.ProjectItem
import com.gcode.imaker.ui.model.projects

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeFragment(activity: Activity) {
    ProjectItems(projects = projects,activity)
}

@Composable
fun HomeFragmentWebView(modifier: Modifier){
    AndroidView(
        modifier = modifier,
        factory = { context->
            val webView = WebView(context)
            webView.settings.javaScriptCanOpenWindowsAutomatically = true
            webView.settings.domStorageEnabled = true
            webView.settings.loadsImagesAutomatically = true
            webView.settings.mediaPlaybackRequiresUserGesture = false
            webView.webViewClient = WebViewClient()
            webView.loadUrl("http://49.232.14.242/imaker/#/home")
            webView
        })
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun ProjectItems(projects:List<Project>,activity: Activity){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(projects){ item->
            ProjectItem(item,activity)
        }
    }
}