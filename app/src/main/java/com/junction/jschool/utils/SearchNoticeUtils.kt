package com.junction.jschool.utils

import com.gcode.gutils.adapter.BaseItem
import com.junction.jschool.model.FindNoticeModel

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
            val item = bean as FindNoticeModel
            if (item.name.contains(searchName)) {
                searchResult.add(bean)
            }
        }
        return searchResult
    }
}