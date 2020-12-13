package com.example.nfc.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.activity.TeacherHomeActivity
import com.example.nfc.databinding.FragmentTeacherLoginBinding
import com.example.nfc.model.MyClass
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.utils.CommonUtils
import com.example.nfc.viewModel.TeacherLoginFragmentViewModel

class TeacherLoginFragment : DialogFragment() {
    private lateinit var binding: FragmentTeacherLoginBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[TeacherLoginFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teacher_login,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.signIn.setOnClickListener {
            val tchNo = binding.tchNoEditText.text.toString().trim()
            MyClass.setClassTch(tchNo)
            val tchPass = binding.passwordEditText.text.toString().trim()
            val classNo = binding.classNoEditText.text.toString().trim().toInt()
            MyClass.setClassNo(classNo)
            viewModel.teacherLogin(tchNo, tchPass, classNo)
        }

        binding.signOut.setOnClickListener {
            dismiss()
        }

        viewModel.loginResult.observe(this){Object->
            val result = Object.getOrNull()
            if (result != null) {
                if(result=="TRUE"){
                    CommonUtils.showShortMsg(ApplicationUtils.context,"登陆成功")
                    val intent = Intent(ApplicationUtils.context,TeacherHomeActivity::class.java)
                    startActivity(intent)
                }else{
                    CommonUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
                }
            }else{
                CommonUtils.showShortMsg(ApplicationUtils.context,"登陆失败")
            }
        }
    }
}