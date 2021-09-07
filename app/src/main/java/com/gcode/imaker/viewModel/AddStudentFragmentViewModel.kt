package com.gcode.imaker.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.gcode.imaker.network.Repository

class AddStudentFragmentViewModel:ViewModel() {
    inner class TempStudent(val stuNo:String,val stuName: String)

    private val student = MutableLiveData<TempStudent>()

    val addStudentResult = Transformations.switchMap(student){ Object->
        Repository.addStudent(Object.stuNo,Object.stuName)
    }

    fun addStudent(stuNo:String,stuName:String){
        student.postValue(TempStudent(stuNo, stuName))
    }
}