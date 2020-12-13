package com.example.nfc.activity

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nfc.R
import com.example.nfc.adapter.BindingAdapterItem
import com.example.nfc.fragment.TeacherLoginFragment
import com.example.nfc.model.LoginModel
import com.example.nfc.utils.ApplicationUtils
import com.example.nfc.adapter.DataBindingAdapter
import com.example.nfc.databinding.ActivityStartBinding
import com.example.nfc.utils.CommonUtils
import com.example.nfc.utils.DeviceInfUtils


class StartActivity : AppCompatActivity() {

    private val loginModels:MutableList<BindingAdapterItem> = ArrayList()

    //获取屏幕宽度和高度
    private val screenWidth = DeviceInfUtils.getMobileScreenWidth(ApplicationUtils.context)
    @RequiresApi(Build.VERSION_CODES.R)
    private val screenHeight = DeviceInfUtils.getMobileScreenHeight(ApplicationUtils.context)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityStartBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_start
        )

        initView()
        
        val adapter = DataBindingAdapter(loginModels)

        adapter.setOnItemClickListener(object : DataBindingAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                when(position){
                    0->{
                        val dialog = TeacherLoginFragment()
                        dialog.show(supportFragmentManager,"StartActivity")
                    }
                    1->{
                        val intent = Intent(ApplicationUtils.context,StudentActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })

        adapter.setOnItemChildClickListener(object: DataBindingAdapter.OnItemChildClickListener{
            override fun onSwitchItemClick(
                isChecked: Boolean,
                position: Int,
                holder: DataBindingAdapter.ViewHolder
            ) {}

            override fun onSwitchCheckedStatus(
                position: Int,
                holder: DataBindingAdapter.ViewHolder
            ) {}

            override fun onButtonItemClick(holder: DataBindingAdapter.ViewHolder, position: Int) {
                when(position){
                    0->{
                        val dialog = TeacherLoginFragment()
                        dialog.show(supportFragmentManager,"StartActivity")
                    }
                    1->{
                        val intent = Intent(ApplicationUtils.context,StudentActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })

        binding.loginRecyclerView.adapter = adapter
        val manager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.HORIZONTAL
        )
        binding.loginRecyclerView.layoutManager = manager
    }

    private fun initView() {
        val titleAbsoluteSizeSpan = AbsoluteSizeSpan(80)
        val titleStyleSpan = StyleSpan(Typeface.BOLD)

        val subTitleAbsoluteSizeSpan = AbsoluteSizeSpan(40)

        val styleTitleOne = SpannableStringBuilder("我是老师")
        styleTitleOne.setSpan(
            titleAbsoluteSizeSpan,
            0,
            styleTitleOne.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val titleColorSpanOne = ForegroundColorSpan(Color.BLACK)
        styleTitleOne.setSpan(
            titleColorSpanOne,
            0,
            styleTitleOne.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        styleTitleOne.setSpan(
            titleStyleSpan,
            0,
            styleTitleOne.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val styleTitleTwo = SpannableStringBuilder("我是学生")
        styleTitleTwo.setSpan(
            titleAbsoluteSizeSpan,
            0,
            styleTitleOne.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val titleColorSpanTwo = ForegroundColorSpan(Color.WHITE)
        styleTitleTwo.setSpan(
            titleColorSpanTwo,
            0,
            styleTitleOne.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        styleTitleTwo.setSpan(
            titleStyleSpan,
            0,
            styleTitleOne.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val styleSubTitleOne = SpannableStringBuilder("在这里你可以管理你的学生,上下课,查看学生的上课情况,进行补签等诸多功能")
        styleSubTitleOne.setSpan(
            subTitleAbsoluteSizeSpan,
            0,
            styleSubTitleOne.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val subTitleColorSpanOne = ForegroundColorSpan(Color.GRAY)
        styleSubTitleOne.setSpan(
            subTitleColorSpanOne,
            0,
            styleSubTitleOne.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        val styleSubTitleTwo = SpannableStringBuilder("点击此来进行签到,查看你的上课情况统计等，帮助你知道你的学习进度")
        styleSubTitleTwo.setSpan(
            subTitleAbsoluteSizeSpan,
            0,
            styleSubTitleTwo.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val subTitleColorSpanTwo = ForegroundColorSpan(Color.WHITE)
        styleSubTitleTwo.setSpan(
            subTitleColorSpanTwo,
            0,
            styleSubTitleTwo.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        loginModels.apply {
            add(
                LoginModel(
                    AppCompatResources.getDrawable(
                        ApplicationUtils.context,
                        R.drawable.login_model_white_background
                    ),
                    AppCompatResources.getDrawable(ApplicationUtils.context, R.drawable.teacher_icon),
                    styleTitleOne,
                    styleSubTitleOne
                )
            )
            add(
                LoginModel(
                    AppCompatResources.getDrawable(
                        ApplicationUtils.context,
                        R.drawable.login_model_orange_background
                    ),
                    AppCompatResources.getDrawable(ApplicationUtils.context, R.drawable.student_icon),
                    styleTitleTwo,
                    styleSubTitleTwo
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