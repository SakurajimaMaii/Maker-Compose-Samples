package com.gcode.imaker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gcode.imaker.R
import com.gcode.imaker.databinding.FragmentDataBinding
import com.gcode.imaker.ui.adapter.DataFmAdapter


class DataFragment : Fragment() {
    private lateinit var binding:FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_data,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DataFmAdapter(this)
        binding.dataVp.apply{
            this.adapter = adapter

            isUserInputEnabled = false
        }

        binding.classBtn.setOnClickListener {
            binding.dataVp.currentItem = 0
            binding.classBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
            binding.classBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_blue_background)
            binding.personBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.black))
            binding.personBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_white_background)
        }

        binding.personBtn.setOnClickListener {
            binding.dataVp.currentItem = 1
            binding.personBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.white))
            binding.personBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_blue_background)
            binding.classBtn.setTextColor(ContextCompat.getColor(binding.root.context,R.color.black))
            binding.classBtn.background = ContextCompat.getDrawable(binding.root.context,R.drawable.button_white_background)
        }
    }
}