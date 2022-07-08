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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ActivityMainBinding.inflate(inflater, container, false).also {
            it.viewmodel = viewModel
            it.lifecycleOwner = viewLifecycleOwner
        }.root

}