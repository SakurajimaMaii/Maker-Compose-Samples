package com.junction.jschool.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.junction.jschool.R
import com.junction.jschool.databinding.FragmentAddFindNoticeBinding


class AddFindNoticeFragment : DialogFragment() {

    private lateinit var binding:FragmentAddFindNoticeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_find_notice,
            container,
            false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val dialogWindow = dialog!!.window
        val lp = dialogWindow!!.attributes
        dialogWindow.setGravity(Gravity.START)
        lp.x = 0
        lp.y = 0
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialogWindow.attributes = lp
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addYes.setOnClickListener {

        }

        binding.addNo.setOnClickListener {
            dismiss()
        }

        binding.lostTagLv.setLabels(ArrayList<String>().apply {
            add("书包")
            add("蓝色")
            add("操场")
            add("红色")
            add("图书馆")
            add("食堂")
            add("大一")
            add("教学楼")
        })
    }
}