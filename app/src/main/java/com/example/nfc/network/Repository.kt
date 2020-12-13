package com.example.nfc.network

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

object Repository {

    fun teacherLogin(tchNo:String,tchPass:String,classNo:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.teacherLogin(tchNo, tchPass, classNo)
            if(userResponse.status.isNotEmpty()){
                val teacherName =  userResponse.status
                Result.success(teacherName)
            }else{
                Result.failure(RuntimeException("response data array is empty"))
            }
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun addClass(tchNo:String,classNo:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.addClass(tchNo, classNo)
            if(userResponse.status.isNotEmpty()){
                Result.success(userResponse.status)
            }else{
                Result.failure(RuntimeException("response data array is empty"))
            }
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun teacherSignIn(classNo:Int,classTch:String,classStatus:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.teacherSignIn(classNo, classTch, classStatus)
            Result.success(userResponse)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun teacherSignOut(classNo:Int,classTch:String,classStatus:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.teacherSignOut(classNo, classTch, classStatus)
            Result.success(userResponse)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun teacherReissue(stuNo:String,tchNo:String,tchPass:String,courseNo:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.teacherReissue(stuNo, tchNo, tchPass, courseNo)
            Result.success(userResponse)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun addStudent(stuNo:String,stuName:String) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.addStudent(stuNo, stuName)
            Result.success(userResponse)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun searchCheckStatus(stuNo:String) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.searchCheckStatus(stuNo)
            if(userResponse.result.isNotEmpty()){
                Result.success(userResponse.result)
            }else{
                Result.failure(RuntimeException("response data array is empty"))
            }
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun studentSignIn(classNo:Int,classTch:String,stuNo:String) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.studentSignIn(classNo, classTch, stuNo)
            Result.success(userResponse.status)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun searchCourseCount(classTch:String,classNo:Int) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.searchCourseCount(classTch, classNo)
            Result.success(userResponse.Count)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }

    fun searchCourse(tableName:String) = liveData(Dispatchers.IO){
        val result = try {
            val userResponse = Network.searchCourse(tableName)
            Result.success(userResponse.list)
        }catch (e:Exception){
            Result.failure(e)
        }
        emit(result)
    }
}