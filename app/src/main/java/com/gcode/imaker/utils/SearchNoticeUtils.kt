package com.gcode.imaker.utils

import com.gcode.imaker.ui.model.FindNoticeModel

/**
 *作者:created by HP on 2021/5/22 13:24
 *邮箱:sakurajimamai2020@qq.com
 */
object SearchNoticeUtils {
    fun searchNoticeByInput(
        noticeBeans: MutableList<FindNoticeModel>,
        searchName: CharSequence
    ): List<FindNoticeModel> {
        val searchResult: MutableList<FindNoticeModel> = ArrayList()
        for (bean in noticeBeans) {
            if (bean.name.contains(searchName)) {
                searchResult.add(bean)
            }
        }
        return searchResult
    }
}