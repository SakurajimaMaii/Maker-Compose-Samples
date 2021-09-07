package com.gcode.imaker.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gcode.imaker.R
import com.gcode.imaker.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {

    private lateinit var binding:FragmentPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.personWebView.settings.javaScriptEnabled =true
        binding.personWebView.loadUrl("file:///android_asset/person.html")
    }
}