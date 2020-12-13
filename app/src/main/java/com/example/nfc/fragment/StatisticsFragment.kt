package com.example.nfc.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.nfc.R
import com.example.nfc.activity.CourseStatisticsActivity
import com.example.nfc.databinding.FragmentStatisticsBinding
import com.example.nfc.utils.ApplicationUtils

class StatisticsFragment : DialogFragment() {
    private var message:String = ""

    private lateinit var binding:FragmentStatisticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            message = bundle.getSerializable("message") as String
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_statistics,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.courseCountTextView.text = message

        binding.yes.setOnClickListener {
            val intent = Intent(ApplicationUtils.context,CourseStatisticsActivity::class.java)
            val value = "course"+binding.classNoEditText.text.toString().trim()
            intent.putExtra("message",value)
            startActivity(intent)
        }

        binding.no.setOnClickListener {
            dismiss()
        }
    }
}