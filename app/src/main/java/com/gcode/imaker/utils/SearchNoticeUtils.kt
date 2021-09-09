package com.gcode.imaker.utils

import com.gcode.imaker.ui.model.FindNotice

/**
 *作者:created by HP on 2021/5/22 13:24
 *邮箱:sakurajimamai2020@qq.com
 */
object SearchNoticeUtils {
    fun searchNoticeByInput(
        noticeBeans: MutableList<FindNotice>,
        searchName: CharSequence
    ): List<FindNotice> {
        val searchResult: MutableList<FindNotice> = ArrayList()
        for (bean in noticeBeans) {
            if (bean.name.contains(searchName)) {
                searchResult.add(bean)
            }
        }
        return searchResult
    }
}