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

        binding.webView.loadUrl("file:///android_asset/student.html")
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true

        //设置上下课选项不可见，避免误操作
        binding.beginClassCardView.visibility = View.GONE
        binding.finishClassCardView.visibility = View.GONE

        binding.addClassCardView.setOnClickListener {
            viewModel.addClass(MyClass.getClassNo(), MyClass.getClassTch())
            //设置上下课选项可见
            binding.beginClassCardView.visibility = View.VISIBLE
            binding.finishClassCardView.visibility = View.VISIBLE
        }

        viewModel.addClassResult.observe(viewLifecycleOwner){ Object->
            val result = Object.getOrNull()
            if (result=="TRUE"){
                MsgWindowUtils.showShortMsg(ApplicationUtils.context, "创建成功")
            }
        }

        binding.beginClassCardView.setOnClickListener {
            viewModel.signIn(MyClass.getClassNo(), MyClass.getClassTch(), 1)
        }

        viewModel.signInResult.observe(viewLifecycleOwner){ Object->
            val result = Object.getOrNull()
            if(result!=null){
                MsgWindowUtils.showShortMsg(ApplicationUtils.context, "正在上课")
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context, "操作失败")
            }
        }

        binding.finishClassCardView.setOnClickListener {
            viewModel.signOut(MyClass.getClassNo(), MyClass.getClassTch(), 0)
        }

        viewModel.signOutResult.observe(viewLifecycleOwner){ Object->
            val result = Object.getOrNull()
            if(result!=null){
                MsgWindowUtils.showShortMsg(ApplicationUtils.context, "下课")
                //设置上下课选项不可见，避免误操作
                binding.beginClassCardView.visibility = View.GONE
                binding.finishClassCardView.visibility = View.GONE
            }else{
                MsgWindowUtils.showShortMsg(ApplicationUtils.context, "操作失败")
            }
        }

        binding.addStudentCardView.setOnClickListener {

        }

        binding.reissueCardView.setOnClickListener {
            val dialog = ReleaseFragment()
            dialog.show(childFragmentManager, "HomeFragment")
        }

        binding.statisticsCardView.setOnClickListener {
            viewModel.searchCourseCount(MyClass.getClassNo(), MyClass.getClassTch())
        }
    }
}