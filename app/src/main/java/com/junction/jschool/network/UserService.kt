package com.junction.jschool.network

import com.junction.jschool.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    /**
     * 教师登录
     * @param tchNo Int
     * @param tchPass String
     * @param classNo Int
     * @return Call<TeacherLoginResult>
     */
    @GET("teacherLogin")
    fun teacherLogin(@Query("tchNo") tchNo:String,
                     @Query("tchPass") tchPass:String,
                     @Query("classNo") classNo:Int):Call<TeacherLoginResult>

    /**
     * 创建课堂
     * @param tchNo String
     * @param classNo Int
     * @return Call<AddClassResult>
     */
    @GET("addClass")
    fun addClass(@Query("tchNo") tchNo:String,
                 @Query("classNo") classNo:Int):Call<AddClassResult>


    /**
     * 教师上课
     * @param classNo Int
     * @param classTch String
     * @param classStatus Int
     * @return Call<TeacherSignIn>
     */
    @GET("teacherSignIn")
    fun teacherSignIn(@Query("classNo") classNo:Int,
                      @Query("classTch") classTch:String,
                      @Query("classStatus") classStatus:Int):Call<TeacherSignInResult>

    /**
     * 教师上课
     * @param classNo Int
     * @param classTch String
     * @param classStatus Int
     * @return Call<TeacherSignIn>
     */
    @GET("teacherSignOut")
    fun teacherSignOut(@Query("classNo") classNo:Int,
                      @Query("classTch") classTch:String,
                      @Query("classStatus") classStatus:Int):Call<TeacherSignOutResult>

    /**
     * 教师补签
     * @param stuNo String
     * @param tchNo String
     * @param tchPass String
     * @param courseNo Int
     * @return Call<TeacherSignOut>
     */
    @GET("teacherReissue")
    fun teacherReissue(@Query("stuNo") stuNo:String,
                       @Query("tchNo") tchNo:String,
                       @Query("tchPass") tchPass:String,
                       @Query("courseNo") courseNo:Int):Call<TeacherReissueResult>


    /**
     * 添加学生
     * @param stuNo String
     * @param stuName String
     * @return Call<AddStudent>
     */
    @GET("addStudent")
    fun addStudent(@Query("stuNo") stuNo:String,
                   @Query("stuName") stuName:String):Call<AddStudentResult>

    /**
     * 查找签到结果
     * @param stuNo String
     * @return Call<AddStudent>
     */
    @GET("searchCheckStatus")
    fun searchCheckStatus(@Query("stuNo") stuNo:String):Call<SearchCheckStatusResult>

    /**
     * 查找签到结果
     * @param stuNo String
     * @return Call<AddStudent>
     */
    @GET("studentSignIn")
    fun studentSignIn(@Query("classNo") classNo:Int,
                      @Query("classTch") classTch:String,
                      @Query("stuNo") stuNo:String):Call<StudentSignInResult>

    /**
     * 查询上课次数
     * @param tchNo String
     * @param classNo Int
     * @return Call<AddClassResult>
     */
    @GET("searchCourseCount")
    fun searchCourseCount(@Query("tchNo") tchNo:String,
                          @Query("classNo") classNo:Int):Call<SearchCourseCountResult>
}