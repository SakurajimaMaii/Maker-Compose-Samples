package com.gcode.imaker.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.gcode.imaker.network.Repository

class StudentSignInFragmentViewModel:ViewModel() {
        private inner class TempStudent(val classNo:Int,val classTch:String,val stuNo:String)

    private val student = MutableLiveData<TempStudent>()

    val signInResult = Transformations.switchMap(student){ Object->
        Repository.studentSignIn(Object.classNo,Object.classTch,Object.stuNo)
    }

    fun studentSignIn(classNo:Int,classTch:String,stuNo:String){
        student.postValue(TempStudent(classNo, classTch, stuNo))
    }
}