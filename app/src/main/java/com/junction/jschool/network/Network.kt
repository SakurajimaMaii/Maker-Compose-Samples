package com.junction.jschool.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object Network {
    //用户信息动态代理对象
    private val userService = ServiceCreator.userCreate(UserService::class.java)

    suspend fun teacherLogin(tchNo:String,tchPass:String,classNo:Int) = userService.teacherLogin(tchNo, tchPass, classNo).await()

    suspend fun addClass(tchNo:String,classNo:Int) = userService.addClass(tchNo, classNo).await()

    suspend fun teacherSignIn(classNo:Int,classTch:String,classStatus:Int) = userService.teacherSignIn(classNo, classTch, classStatus).await()

    suspend fun teacherSignOut(classNo:Int,classTch:String,classStatus:Int) = userService.teacherSignOut(classNo, classTch, classStatus).await()

    suspend fun teacherReissue(stuNo:String,tchNo:String,tchPass:String,courseNo:Int) = userService.teacherReissue(stuNo, tchNo, tchPass, courseNo).await()

    suspend fun addStudent(stuNo:String,stuName:String) = userService.addStudent(stuNo,stuName).await()

    suspend fun searchCheckStatus(stuNo:String) = userService.searchCheckStatus(stuNo).await()

    suspend fun studentSignIn(classNo:Int,classTch:String,stuNo:String) = userService.studentSignIn(classNo, classTch, stuNo).await()

    suspend fun searchCourseCount(classTch:String,classNo:Int) = userService.searchCourseCount(classTch,classNo).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine { continuation ->
            enqueue(object :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if(body!=null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}