package com.example.nfc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.nfc.R
import com.example.nfc.databinding.SettingFragmentBinding


class SettingFragment : Fragment() {
    private lateinit var binding:SettingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.setting_fragment,
            container, false
        )
        return binding.root
    }

}