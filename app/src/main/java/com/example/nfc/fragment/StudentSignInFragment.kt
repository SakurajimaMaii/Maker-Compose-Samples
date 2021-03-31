package com.example.nfc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.databinding.FragmentStudentSignInBinding
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.viewModel.StudentSignInFragmentViewModel
import com.gcode.gutils.MsgWindowUtils

class StudentSignInFragment : DialogFragment() {

    private lateinit var binding:FragmentStudentSignInBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[StudentSignInFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_student_sign_in,
            container,
            false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.checkIn.setOnClickListener {
            val classNo = binding.classNoEditText.text.toString().trim().toInt()
            val classTch = binding.tchNoEditText.text.toString().trim()
            val stuNo = binding.stuNoEditText.text.toString().trim()
            viewModel.studentSignIn(classNo,classTch,stuNo)
        }

        binding.checkOut.setOnClickListener {
            dismiss()
        }

        viewModel.signInResult.observe(this){Object->
            val result = Object.getOrNull()
            if(result != ""){
                if (result=="TRUE"){
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"签到成功")
                }else{
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"签到失败")
                }
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context,"签到失败")
            }
        }
    }
}