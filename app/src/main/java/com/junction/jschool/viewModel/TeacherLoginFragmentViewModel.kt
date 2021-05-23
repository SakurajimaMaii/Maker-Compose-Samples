package com.junction.jschool.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.junction.jschool.network.Repository

class TeacherLoginFragmentViewModel:ViewModel() {
    inner class TempTeacher(val tchNo:String,val tchPass:String,val classNo:Int)

    private val teacher = MutableLiveData<TempTeacher>()

    val loginResult = Transformations.switchMap(teacher){Object->
        Repository.teacherLogin(Object.tchNo,Object.tchPass,Object.classNo)
    }

    fun teacherLogin(tchNo:String,tchPass:String,classNo:Int){
        teacher.postValue(TempTeacher(tchNo, tchPass, classNo))
    }
}
