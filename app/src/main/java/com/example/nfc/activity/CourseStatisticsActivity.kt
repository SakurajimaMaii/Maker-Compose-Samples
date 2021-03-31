package com.example.nfc.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nfc.R
import com.example.nfc.adapter.BindingAdapterItem
import com.example.nfc.adapter.DataBindingAdapter
import com.example.nfc.databinding.ActivityCourseStatisticsBinding
import com.example.nfc.viewModel.CourseStatisticsActivityViewModel

class CourseStatisticsActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CourseStatisticsActivityViewModel::class.java]
    }

    private lateinit var binding:ActivityCourseStatisticsBinding

    private val data:MutableList<BindingAdapterItem> = ArrayList<BindingAdapterItem>()
    private var tableName:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tableName = intent.getStringExtra("message").toString()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_course_statistics)

        val adapter = DataBindingAdapter(data)
        binding.studentCourseStatusRecyclerView.adapter = adapter
        val manager = LinearLayoutManager(this)
        binding.studentCourseStatusRecyclerView.layoutManager = manager

        binding.refresh.setOnClickListener {
            viewModel.setTableName(tableName)
        }

        viewModel.courseStatisticsResult.observe(this){Object->
            val result = Object.getOrNull()
            if(result!=null){
                val list:MutableList<BindingAdapterItem> = ArrayList<BindingAdapterItem>()
                for(item in result){
                    list.add(item)
                }
                val adapterOther = DataBindingAdapter(list)
                binding.studentCourseStatusRecyclerView.adapter = adapterOther
            }
        }
    }
}