package com.example.nfc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.databinding.FragmentReissueBinding
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.viewModel.ReissueFragmentViewModel
import com.gcode.gutils.MsgWindowUtils

class ReissueFragment : DialogFragment() {
    private lateinit var binding:FragmentReissueBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[ReissueFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_reissue,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.reissueIn.setOnClickListener {
            val stuNo = binding.stuNoEditText.text.toString().trim()
            val tchNo = binding.tchNoEditText.text.toString().trim()
            val tchPass = binding.passwordEditText.text.toString().trim()
            val courseNo = binding.courseNoEditText.text.toString().trim().toInt()
            viewModel.reissue(stuNo,tchNo,tchPass,courseNo)
        }

        binding.reissueOut.setOnClickListener {
            dismiss()
        }

        viewModel.reissueResult.observe(this){Object->
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