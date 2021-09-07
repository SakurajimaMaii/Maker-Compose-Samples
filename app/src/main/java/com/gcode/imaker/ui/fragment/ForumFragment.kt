package com.gcode.imaker.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gcode.imaker.R
import com.gcode.imaker.databinding.FragmentForumBinding

class ForumFragment : Fragment() {

    private lateinit var binding:FragmentForumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_forum, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            binding.transformationLayout.startTransform()
        }

        binding.cv.setOnClickListener {
            binding.transformationLayout.finishTransform()
        }

        binding.listWv.loadUrl("file:///android_asset/list.html")
    }
}