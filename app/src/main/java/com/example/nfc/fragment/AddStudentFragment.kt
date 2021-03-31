package com.example.nfc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.databinding.FragmentAddStudentBinding
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.viewModel.AddStudentFragmentViewModel
import com.gcode.gutils.MsgWindowUtils

class AddStudentFragment : DialogFragment() {
    private lateinit var binding:FragmentAddStudentBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[AddStudentFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_student,
            container,
            false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.addYes.setOnClickListener {
            val stuNo = binding.stuNoEditText.text.toString().trim()
            val stuName = binding.stuNameEditText.text.toString().trim()
            viewModel.addStudent(stuNo,stuName)
        }

        binding.addNo.setOnClickListener {
            dismiss()
        }

        viewModel.addStudentResult.observe(this){Object->
            val result = Object.getOrNull()
            if(result!=null){
                if(result.status=="TRUE"){
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"操作成功")
                }else{
                    MsgWindowUtils.showShortMsg(ApplicationUtils.context,"操作失败")
                }
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context,"操作失败")
            }
        }
    }
}