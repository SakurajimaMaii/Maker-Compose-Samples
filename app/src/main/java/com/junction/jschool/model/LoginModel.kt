package com.junction.jschool.model

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.gcode.gutils.adapter.BaseItem
import com.junction.jschool.BR
import com.junction.jschool.R

/**
 * 开始页面登录模板
 * @param imageId 图片id
 * @param title 标题
 * @param subTitle 副标题
 * @param background 背景图id
 */
class LoginModel(
    private var background: Drawable?,
    private var imageId: Drawable?,
    private var title: String,
    private var subTitle: String
) : BaseObservable(), BaseItem {
    @Bindable
    fun getImageId(): Drawable? {
        return imageId
    }

    fun setImageId(imageId: Drawable) {
        this.imageId = imageId
        notifyPropertyChanged(BR.imageId)
    }

    @Bindable
    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
        notifyPropertyChanged(BR.title)
    }

    @Bindable
    fun getSubTitle(): String {
        return subTitle
    }

    fun setSubTitle(subTitle: String) {
        this.subTitle = subTitle
        notifyPropertyChanged(BR.subTitle)
    }

    @Bindable
    fun getBackground(): Drawable? {
        return background
    }

    fun setBackground(background: Drawable) {
        this.background = background
        notifyPropertyChanged(BR.background)
    }

    override fun getItemBindViewType(): Int {
        return R.layout.login_model_item
    }

    override fun getItemViewType(): Int {
        return -100
    }
}