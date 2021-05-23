package com.junction.jschool.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.junction.jschool.R
import com.junction.jschool.databinding.FragmentClassBinding
import com.junction.jschool.databinding.FragmentPersonBinding

class ClassFragment : Fragment() {

    private lateinit var binding: FragmentClassBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_class, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.classWebView.settings.javaScriptEnabled =true
        binding.classWebView.loadUrl("file:///android_asset/class.html")
    }

}