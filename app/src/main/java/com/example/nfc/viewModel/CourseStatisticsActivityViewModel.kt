package com.example.nfc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.nfc.network.Repository

class CourseStatisticsActivityViewModel:ViewModel() {
    private val tableName = MutableLiveData<String>()

    val courseStatisticsResult = Transformations.switchMap(tableName){Object->
        Repository.searchCourse(Object)
    }

    fun setTableName(tableName:String){
        this.tableName.postValue(tableName)
    }
}