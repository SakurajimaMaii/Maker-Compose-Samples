package com.junction.jschool.activity

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gcode.gutils.utils.MsgWindowUtils
import com.junction.jschool.R
import com.junction.jschool.databinding.ActivityLoginBinding
import com.junction.jschool.model.MyClass
import com.junction.jschool.utils.ApplicationUtils
import com.junction.jschool.viewModel.TeacherLoginFragmentViewModel

class LoginActivity : BaseActivity() {

    companion object{
        const val userType = "userType"
        const val tchType = "tch"
        const val stuType = "stu"
        const val staffType = "staff"
    }

    private lateinit var binding: ActivityLoginBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[TeacherLoginFragmentViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取用户类型
        val str = intent.getStringExtra(userType)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_login
        )


        when(str){
            tchType->{
                binding.loginTitle.text = "老师登录"
                binding.loginRootLayout.background = ContextCompat.getDrawable(this,R.drawable.tch_login_bk)
            }
            stuType->{
                binding.loginTitle.text = "学生登录"
                binding.loginRootLayout.background = ContextCompat.getDrawable(this,R.drawable.stu_login_bk)
            }
            staffType->{
                binding.loginTitle.text = "维护人员登录"
                binding.loginRootLayout.background = ContextCompat.getDrawable(this,R.drawable.staff_login_bk)
            }
        }

        binding.signIn.setOnClickListener {
            val tchNo = binding.tchNoEditText.text.toString().trim()
            MyClass.setClassTch(tchNo)
            val tchPass = binding.passwordEditText.text.toString().trim()
            val intent = Intent(ApplicationUtils.context,HomeActivity::class.java)
            startActivity(intent)
        }
        viewModel.loginResult.observe(this){Object->
            val result = Object.getOrNull()
            if (result != null) {
                if(result=="TRUE"){
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆成功")
                    val intent = Intent(ApplicationUtils.context,HomeActivity::class.java)
                    startActivity(intent)
                }else{
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
                }
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
            }
        }
    }
}