package com.junction.jschool.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.junction.jschool.R
import com.junction.jschool.databinding.FragmentPersonBinding

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