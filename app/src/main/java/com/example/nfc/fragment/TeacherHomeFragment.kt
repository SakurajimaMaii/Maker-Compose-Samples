package com.example.nfc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.databinding.FragmentTeacherHomeBinding
import com.example.nfc.model.MyClass
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.viewModel.TeacherHomeFragmentViewModel
import com.gcode.gutils.MsgWindowUtils


class TeacherHomeFragment:Fragment() {
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
            val dialog = AddStudentFragment()
            dialog.show(childFragmentManager, "TeacherHomeFragment")
        }

        binding.reissueCardView.setOnClickListener {
            val dialog = ReissueFragment()
            dialog.show(childFragmentManager, "TeacherHomeFragment")
        }

        binding.statisticsCardView.setOnClickListener {
            viewModel.searchCourseCount(MyClass.getClassNo(), MyClass.getClassTch())
        }

        viewModel.courseCountResult.observe(viewLifecycleOwner){ Object->
            val result = Object.getOrNull()
            if(result!=null){
                val dialog = StatisticsFragment()
                val bundle = Bundle()
                bundle.putSerializable("message", result.toString())
                dialog.arguments = bundle
                dialog.show(childFragmentManager, "TeacherHomeFragment")
            }
        }
    }
}