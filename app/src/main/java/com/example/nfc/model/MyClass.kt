package com.example.nfc.model

object MyClass {
    private var classNo:Int = 0
    private var classTch:String = ""

    @JvmStatic
    fun setClassNo(classNo:Int){
        this.classNo = classNo
    }

    @JvmStatic
    fun getClassNo() = classNo

    @JvmStatic
    fun setClassTch(classTch:String){
        this.classTch = classTch
    }

    @JvmStatic
    fun getClassTch() = classTch
}