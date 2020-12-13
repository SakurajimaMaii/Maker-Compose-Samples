package com.example.nfc.utils

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.nfc.Constant

@SuppressLint("HandlerLeak")
class HandlerUtils : Handler(Looper.getMainLooper()) {
    override fun handleMessage(message: Message) {
        super.handleMessage(message)
        when (message.what) {
            Constant.MSG_GOT_DATA -> CommonUtils.showShortMsg(ApplicationUtils.context,"data_icon:" + message.obj.toString())
            Constant.MSG_ERROR -> CommonUtils.showShortMsg(ApplicationUtils.context,"error:" + message.obj.toString())
            Constant.MSG_CONNECTED_TO_SERVER -> CommonUtils.showShortMsg(ApplicationUtils.context,"连接到服务端")
            Constant.MSG_GOT_A_CLINET -> CommonUtils.showShortMsg(ApplicationUtils.context,"找到服务端")
        }
    }
}