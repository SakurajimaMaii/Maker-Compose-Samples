package com.gcode.imaker.ui.model

data class TeacherLoginResult(val status:String,val teacher:String)

data class AddClassResult(val status:String)

data class TeacherSignInResult(val classNo:String,val currentClassStatus:String,val status: String)

data class TeacherSignOutResult(val classNo:String,val currentClassStatus:String,val status: String)

data class TeacherReissueResult(val status: String)

data class AddStudentResult(val status: String)

data class SearchCheckStatusResult(val result:List<Int>,val status: String)

data class StudentSignInResult(val status:String,val student: String)

data class SearchCourseCountResult(val Count:Int,val status:String)