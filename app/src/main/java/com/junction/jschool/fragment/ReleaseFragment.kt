package com.junction.jschool.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.junction.jschool.BR
import com.junction.jschool.R
import com.junction.jschool.model.ReleaseModel
import com.junction.jschool.viewModel.ReissueFragmentViewModel
import com.gcode.gutils.adapter.BaseBindingAdapter
import com.gcode.gutils.adapter.BaseItem
import com.junction.jschool.activity.FindNoticeActivity
import com.junction.jschool.activity.GameActivity
import com.junction.jschool.databinding.FragmentReleaseBinding
import com.junction.jschool.utils.ApplicationUtils

class ReleaseFragment : DialogFragment() {
    private lateinit var binding:FragmentReleaseBinding

    private val releaseModels = ArrayList<BaseItem>().apply {
        add(ReleaseModel(ContextCompat.getDrawable(ApplicationUtils.context,R.drawable.ic_release_friend), "交友"))
        add(ReleaseModel(ContextCompat.getDrawable(ApplicationUtils.context,R.drawable.ic_release_game),"竞赛活动"))
        add(ReleaseModel(ContextCompat.getDrawable(ApplicationUtils.context,R.drawable.ic_release_find_notice),"寻物启事"))
        add(ReleaseModel(ContextCompat.getDrawable(ApplicationUtils.context,R.drawable.ic_release_recruit),"社团招募"))
        add(ReleaseModel(ContextCompat.getDrawable(ApplicationUtils.context,R.drawable.ic_release_add),"敬请期待"))
    }

    inner class ReleaseModelAdapter(items: MutableList<BaseItem>) : BaseBindingAdapter(items){
        override fun setVariableId(): Int {
            return BR.rm
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_release,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.releaseInfTypeList.apply {
            layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
            adapter = ReleaseModelAdapter(releaseModels).apply {
                setOnItemClickListener(object :BaseBindingAdapter.OnItemClickListener{
                    override fun onItemClick(itemView: View?, pos: Int) {
                        when(pos){
                            1->{
                                startActivity(Intent(this@ReleaseFragment.context,GameActivity::class.java))
                            }
                            2->{
                                startActivity(Intent(this@ReleaseFragment.context,FindNoticeActivity::class.java))
                            }
                        }
                    }
                })
            }
        }

    }
}