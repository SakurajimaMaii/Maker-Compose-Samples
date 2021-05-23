package com.junction.jschool.utils

import android.app.Application
import android.content.Context

/**
 * 获取全局Context
 */
class ApplicationUtils:Application(){
    companion object{
        lateinit var context: Context

        //心知天气私钥
        const val TOKEN = "S31j3rFgSwemrvy9h"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}