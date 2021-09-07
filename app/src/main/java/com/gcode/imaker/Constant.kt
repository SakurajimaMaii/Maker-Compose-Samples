package com.gcode.imaker

import java.io.Serializable

/**
 *作者:created by HP on 2021/9/7 18:04
 *邮箱:sakurajimamai2020@qq.com
 */
/**
 * 给定状态参数常量
 */
object Constant : Serializable {
    /**
     * 有客户端连接
     */
    const val MSG_GOT_A_CLINET = 3

    /**
     * 连接到服务器
     */
    const val MSG_CONNECTED_TO_SERVER = 4

    /**
     * 获取到数据
     */
    const val MSG_GOT_DATA = 5

    /**
     * 出错
     */
    const val MSG_ERROR = -1

    /**
     * startAct to SignAct Tag
     */
    const val SIGN_ACTION_TAG = "SIGN_ACTION"
}