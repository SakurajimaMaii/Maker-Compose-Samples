package com.gcode.imaker.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcode.imaker.R
import com.gcode.imaker.databinding.ActivityFindNoticeBinding
import com.gcode.imaker.ui.adapter.FindNoticeAdapter
import com.gcode.imaker.ui.fragment.AddFindNoticeFragment
import com.gcode.imaker.ui.model.FindNoticeModel
import com.gcode.imaker.utils.SearchNoticeUtils

class FindNoticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindNoticeBinding

    /**
     * 搜索到的数据
     */
    private var searchResult: List<FindNoticeModel> = ArrayList()

    /**
     * 做个数据缓存
     */
    private val cacheNoticeData: MutableList<FindNoticeModel> = ArrayList()

    private lateinit var findNotices:MutableList<FindNoticeModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_find_notice)

        binding.titleOne.typeface = Typeface.DEFAULT_BOLD
        binding.titleOne.textSize = 25f
        binding.titleTwo.typeface = Typeface.DEFAULT
        binding.titleTwo.textSize = 20f

        findNotices = ArrayList<FindNoticeModel>().apply {
            apply {

                val findNoticeItem = FindNoticeModel(
                    "平板",
                    "在食堂的时候不小心把平板搞丢了,想问一下有没有人捡到我的平板",
                    ArrayList<String>().apply {
                        add("华为")
                    },
                    ContextCompat.getDrawable(this@FindNoticeActivity,R.drawable.ipad)
                )
                add(findNoticeItem)
                cacheNoticeData.add(findNoticeItem)

                val findNoticeItem1 = FindNoticeModel(
                    "书包",
                    "一个蓝色书包,在操场附近丢的",
                    ArrayList<String>().apply {
                        add("书包")
                        add("蓝色")
                        add("操场")
                    },
                    ContextCompat.getDrawable(this@FindNoticeActivity, R.drawable.bag)
                )
                add(findNoticeItem1)
                cacheNoticeData.add(findNoticeItem1)

                val findNoticeItem2 = FindNoticeModel(
                    "学生卡",
                    "丢了了一张学生卡,学号19104565,还请捡到的小伙伴联系我",
                    ArrayList<String>().apply {
                        add("经管学院")
                        add("19级")
                    },
                    ContextCompat.getDrawable(this@FindNoticeActivity,R.drawable.lost)
                )
                add(findNoticeItem2)
                cacheNoticeData.add(findNoticeItem2)

                val findNoticeItem3 = FindNoticeModel(
                    "耳机",
                    "在六号楼211丢了一副耳机,Airpods的,有没有伙伴看见啊",
                    ArrayList<String>().apply {
                        add("Airpods")
                        add("Apple")
                        add("耳机")
                    },
                    ContextCompat.getDrawable(this@FindNoticeActivity,R.drawable.earphone)
                )
                add(findNoticeItem3)
                cacheNoticeData.add(findNoticeItem3)

                val findNoticeItem4 = FindNoticeModel(
                    "小米手环",
                    "操场打球的时候不知道放在那里了,有没有下午2点在操场打球的伙伴看见",
                    ArrayList<String>().apply {
                        add("小米")
                        add("手环")
                        add("篮球操场")
                    },
                    ContextCompat.getDrawable(this@FindNoticeActivity,R.drawable.wing)
                )
                add(findNoticeItem4)
                cacheNoticeData.add(findNoticeItem4)
            }
        }

        val adapter = FindNoticeAdapter(findNotices)

        binding.findNoticeList.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@FindNoticeActivity)
        }

        binding.noticeSv.isSubmitButtonEnabled = true
        binding.noticeSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                searchResult = SearchNoticeUtils.searchNoticeByInput(findNotices, query)
                findNotices.clear()
                findNotices.addAll(searchResult)
                adapter.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                findNotices.clear()
                findNotices.addAll(cacheNoticeData)
                adapter.notifyDataSetChanged()
                return false
            }
        })

        binding.titleOne.setOnClickListener {
            binding.titleOne.typeface = Typeface.DEFAULT_BOLD
            binding.titleOne.textSize = 25f
            binding.titleTwo.typeface = Typeface.DEFAULT
            binding.titleTwo.textSize = 20f
        }

        binding.titleTwo.setOnClickListener {
            binding.titleOne.typeface = Typeface.DEFAULT
            binding.titleOne.textSize = 20f
            binding.titleTwo.typeface = Typeface.DEFAULT_BOLD
            binding.titleTwo.textSize = 25f
            val dialog = AddFindNoticeFragment()
            dialog.show(supportFragmentManager,"FindNoticeActivity")
        }
    }
}