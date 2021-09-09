package com.gcode.imaker.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gcode.tools.utils.MsgWindowUtils
import com.gcode.imaker.R
import com.gcode.imaker.databinding.FragmentTeacherHomeBinding
import com.gcode.imaker.ui.model.MyClass
import com.gcode.imaker.utils.ApplicationUtils
import com.gcode.imaker.viewModel.TeacherHomeFragmentViewModel


class HomeFragment:Fragment() {
    private lateinit var binding:FragmentTeacherHomeBinding

    private val viewModel:TeacherHomeFragmentViewModel by lazy {
        ViewModelProvider(this)[TeacherHomeFragmentViewModel::class.java]
    }

    //加载布局
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teacher_home,
            container,
            false
        )
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}