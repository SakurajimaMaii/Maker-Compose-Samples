package com.gcode.imaker.ui.model

object MyClass {
    private var classNo:Int = 0
    private var classTch:String = ""

    @JvmStatic
    fun setClassNo(classNo:Int){
        MyClass.classNo = classNo
    }

    @JvmStatic
    fun getClassNo() = classNo

    @JvmStatic
    fun setClassTch(classTch:String){
        MyClass.classTch = classTch
    }

    @JvmStatic
    fun getClassTch() = classTch
}