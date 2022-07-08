package com.noactivity.noactivitytest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.noactivity.noactivitytest.databinding.ActivityMainBinding
import com.noactivity.noactivitytest.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        //return super.onCreateView(inflater, container, savedInstanceState)

        val binding = ActivityMainBinding.inflate(inflater, container, false)

        //binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }

}