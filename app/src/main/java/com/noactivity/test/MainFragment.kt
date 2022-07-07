package com.noactivity.test


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

class MainFragment : Fragment()
{

    private val _viewmodel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)


        // DataBinding準備
        var binding = DataBindingUtil.inflate<ActivityMainBinding>(inflater, R.layout.activity_main, textview, false)

        // ViewModel紐づけ
        binding.viewmodel = _viewmodel

        return binding.root

    }

}