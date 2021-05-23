package com.junction.jschool.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcode.gutils.adapter.BaseBindingAdapter
import com.gcode.gutils.adapter.BaseItem
import com.junction.jschool.BR
import com.junction.jschool.R
import com.junction.jschool.databinding.ActivityStartBinding
import com.junction.jschool.model.LoginModel
import com.junction.jschool.utils.ApplicationUtils


class StartActivity : AppCompatActivity() {

    companion object{
        const val userType = "userType"
        const val tchType = "tch"
        const val stuType = "stu"
        const val staffType = "staff"
    }

    private inner class LoginModelAdapter(items: MutableList<BaseItem>) : BaseBindingAdapter(items){
        override fun setVariableId(): Int {
            return BR.item
        }
    }

    private val loginModels:MutableList<BaseItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityStartBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_start
        )

        initView()
        
        val adapter = LoginModelAdapter(loginModels)

        adapter.setOnItemClickListener(object :BaseBindingAdapter.OnItemClickListener{
            override fun onItemClick(itemView: View?, pos: Int) {
                when(pos){
                    0->{
                        val intent = Intent(binding.root.context,LoginActivity::class.java).apply {
                            putExtra(userType, tchType)
                        }
                        startActivity(intent)
                    }
                    1->{
                        val intent = Intent(binding.root.context,LoginActivity::class.java).apply {
                            putExtra(userType, stuType)
                        }
                        startActivity(intent)
                    }
                    2->{
                        val intent = Intent(binding.root.context,LoginActivity::class.java).apply {
                            putExtra(userType, staffType)
                        }
                        startActivity(intent)
                    }
                }
            }
        }

        )

        binding.loginRecyclerView.adapter = adapter
        binding.loginRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initView() {
        loginModels.apply {
            add(
                LoginModel(
                    AppCompatResources.getDrawable(
                        ApplicationUtils.context,
                        R.drawable.login_model_green_sea_bk
                    ),
                    AppCompatResources.getDrawable(ApplicationUtils.context, R.drawable.teacher_icon),
                    "我是老师",
                    "在这里你可以管理你的学生,上下课,查看学生的上课情况,进行补签等诸多功能"
                )
            )
            add(
                LoginModel(
                    AppCompatResources.getDrawable(
                        ApplicationUtils.context,
                        R.drawable.login_model_orange_bk
                    ),
                    AppCompatResources.getDrawable(ApplicationUtils.context, R.drawable.student_icon),
                    "我是学生",
                    "点击此来进行签到,查看你的上课情况统计等，帮助你知道你的学习进度"
                )
            )
            add(
                LoginModel(
                    AppCompatResources.getDrawable(
                        ApplicationUtils.context,
                        R.drawable.login_model_blue_bk
                    ),
                    AppCompatResources.getDrawable(ApplicationUtils.context, R.drawable.ic_maintenance),
                    "我是维修工人",
                    "点击此来查看学校设施的运行情况"
                )
            )
        }
    }

    //    private fun initView() {
//        binding.videoView.apply {
//            //设置播放加载路径
//            setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.test2))
//            //播放
//            start()
//            //循环播放
//            setOnCompletionListener { binding.videoView.start() }
//        }
//    }
//
//    //返回重启加载
//    override fun onRestart() {
//        initView()
//        super.onRestart()
//    }
//
//    //防止锁屏或者切出的时候，音乐在播放
//    override fun onStop() {
//        binding.videoView.stopPlayback()
//        super.onStop()
//    }
}