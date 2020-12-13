package com.example.nfc.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.nfc.BR;
import com.example.nfc.R;
import com.example.nfc.adapter.BindingAdapterItem;

public class StudentCourseStatus extends BaseObservable implements BindingAdapterItem {
    private int No;
    private int classNo;
    private int stuNo;
    private String stuStatus;
    private int tchNo;

    public StudentCourseStatus(int no, int classNo, int stuNo, String stuStatus, int tchNo) {
        No = no;
        this.classNo = classNo;
        this.stuNo = stuNo;
        this.stuStatus = stuStatus;
        this.tchNo = tchNo;
    }

    @Bindable
    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
        notifyPropertyChanged(BR.no);
    }

    @Bindable
    public String getClassNo() {
        return String.valueOf(classNo);
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
        notifyPropertyChanged(BR.classNo);
    }

    @Bindable
    public String getStuNo() {
        return String.valueOf(stuNo);
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
        notifyPropertyChanged(BR.stuNo);
    }

    @Bindable
    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
        notifyPropertyChanged(BR.stuStatus);
    }

    @Bindable
    public String getTchNo() {
        return String.valueOf(tchNo);
    }

    public void setTchNo(int tchNo) {
        this.tchNo = tchNo;
        notifyPropertyChanged(BR.tchNo);
    }

    @Override
    public int getViewType() {
        return R.layout.student_course_status_item;
    }
}
