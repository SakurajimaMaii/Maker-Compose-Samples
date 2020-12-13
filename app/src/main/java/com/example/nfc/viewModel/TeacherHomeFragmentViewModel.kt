package com.example.nfc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.nfc.network.Repository

class TeacherHomeFragmentViewModel:ViewModel() {
    inner class TempTeacher(val classNo:Int,val classTch:String,val classStatus:Int)

    inner class TempClass(val classNo:Int,val classTch:String)

    //用于添加课堂操作
    private val myClassOne = MutableLiveData<TempClass>()
    //用于查询上课次数使用
    private val myClassTwo = MutableLiveData<TempClass>()

    private val signIn = MutableLiveData<TempTeacher>()

    private val signOut = MutableLiveData<TempTeacher>()

    val addClassResult = Transformations.switchMap(myClassOne){Object->
        Repository.addClass(Object.classTch,Object.classNo)
    }

    val signInResult = Transformations.switchMap(signIn){Object->
        Repository.teacherSignIn(Object.classNo,Object.classTch,Object.classStatus)
    }

    val signOutResult = Transformations.switchMap(signOut){Object->
        Repository.teacherSignOut(Object.classNo,Object.classTch,Object.classStatus)
    }

    val courseCountResult = Transformations.switchMap(myClassTwo){Object->
        Repository.searchCourseCount(Object.classTch,Object.classNo)
    }

    fun addClass(classNo:Int,classTch:String){
        myClassOne.postValue(TempClass(classNo,classTch))
    }

    fun signIn(classNo:Int,classTch:String,classStatus:Int){
        signIn.postValue(TempTeacher(classNo, classTch, classStatus))
    }

    fun signOut(classNo:Int,classTch:String,classStatus:Int){
        signOut.postValue(TempTeacher(classNo, classTch, classStatus))
    }

    fun searchCourseCount(classNo:Int,classTch:String){
        myClassTwo.postValue(TempClass(classNo,classTch))
    }
}