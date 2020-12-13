package com.example.nfc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.nfc.network.Repository

class ReissueFragmentViewModel:ViewModel() {
    inner class TempTeacher(val stuNo:String,val classNo:String,val classTch:String,val courseNo:Int)

    private val teacher = MutableLiveData<TempTeacher>()

    val reissueResult = Transformations.switchMap(teacher){Object->
        Repository.teacherReissue(Object.stuNo,Object.classNo,Object.classTch,Object.courseNo)
    }

    fun reissue(stuNo:String,classNo:String,classTch:String,courseNo:Int){
        teacher.postValue(TempTeacher(stuNo, classNo, classTch, courseNo))
    }
}