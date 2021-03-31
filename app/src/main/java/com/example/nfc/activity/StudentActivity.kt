package com.example.nfc.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.nfc.R
import com.example.nfc.databinding.ActivityStudentBinding
import com.example.nfc.fragment.StudentSignInFragment
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.viewModel.StudentActivityViewModel
import com.gcode.gutils.ScreenSizeUtils
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement


class StudentActivity : AppCompatActivity() {
    private lateinit var binding :ActivityStudentBinding

    //获取屏幕宽度
    private val screenWidth = ScreenSizeUtils.getMobileScreenWidth(ApplicationUtils.context)

    private val viewModel by lazy {
        ViewModelProvider(this)[StudentActivityViewModel::class.java]
    }

    //签到次数
    private var checkIn:Int = 0
    private var checkOut:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        //避免键盘弹出影响布局
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student)

        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        binding.checkInValue.apply {
            text = "0"
            textSize = (screenWidth/40).toFloat()
        }
        binding.checkOutValue.apply {
            text = "0"
            textSize = (screenWidth/40).toFloat()
        }

        val aaChartModel = AAChartModel()
            .chartType(AAChartType.Pie)
            .borderRadius(20f)
            .backgroundColor("#ffffff")
            .title("你的签到情况")
            .subtitle("virtual data")
            .dataLabelsEnabled(true)//是否直接显示扇形图数据
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("次数")
                        .data(
                            arrayOf(
                                arrayOf("上课", checkIn),
                                arrayOf("未上课", checkOut)
                            )
                        )
                )
            )

        binding.AAChartView.aa_drawChartWithChartModel(aaChartModel)
    }

    @SuppressLint("InflateParams")
    override fun onStart() {
        super.onStart()
        binding.searchCheckIn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                val view: View = LayoutInflater.from(ApplicationUtils.context).inflate(
                    R.layout.dialog_enter_student_no,
                    null
                )
                setView(view)
                setPositiveButton("确认")
                { _, _ ->
                    val studentNoEditText = view.findViewById<View>(R.id.studentNoEditText) as EditText
                    val stuNo = studentNoEditText.text.toString().trim()
                    viewModel.searchCheckStatus(stuNo)
                }
                setNegativeButton(
                    "退出"
                ) { dialog, _ -> dialog.cancel() }
                show()
            }
        }

        binding.checkIn.setOnClickListener {
            val dialog = StudentSignInFragment()
            dialog.show(supportFragmentManager,"StudentActivity")
        }

        viewModel.searchResult.observe(this){Object->
            val result = Object.getOrNull()
            if (result != null) {
                val res:List<Int> = result
                binding.AAChartView.aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(arrayOf(
                    AASeriesElement()
                        .name("次数")
                        .data(
                            arrayOf(
                                arrayOf("上课", res[0]),
                                arrayOf("未上课", res[1])
                            )
                        )
                ))
                binding.checkInValue.text = res[0].toString()
                binding.checkOutValue.text = res[1].toString()
            }
        }
    }
}