package com.example.nfc.model;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.nfc.BR;
import com.example.nfc.R;
import com.example.nfc.adapter.BindingAdapterItem;

public class LoginModel extends BaseObservable implements BindingAdapterItem {
    private Drawable imageId;
    private Drawable background;
    private SpannableStringBuilder title;
    private SpannableStringBuilder subTitle;

    /**
     * 开始页面登录模板
     * @param imageId 图片id
     * @param title 标题
     * @param subTitle 副标题
     * @param background 背景图id
     */
    public LoginModel(Drawable background, Drawable imageId, SpannableStringBuilder title, SpannableStringBuilder subTitle) {
        this.background = background;
        this.imageId = imageId;
        this.title = title;
        this.subTitle = subTitle;
    }

    @Bindable
    public Drawable getImageId() {
        return imageId;
    }

    public void setImageId(Drawable imageId) {
        this.imageId = imageId;
        notifyPropertyChanged(BR.imageId);
    }

    @Bindable
    public SpannableStringBuilder getTitle() {
        return title;
    }

    public void setTitle(SpannableStringBuilder title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public SpannableStringBuilder getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(SpannableStringBuilder subTitle) {
        this.subTitle = subTitle;
        notifyPropertyChanged(BR.subTitle);
    }

    @Bindable
    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
        notifyPropertyChanged(BR.background);
    }

    @Override
    public int getViewType() {
        return R.layout.login_model_item;
    }
}
