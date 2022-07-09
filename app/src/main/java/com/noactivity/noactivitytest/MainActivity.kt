package com.noactivity.noactivitytest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.noactivity.noactivitytest.databinding.ActivityMainBinding
import com.noactivity.noactivitytest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity()
{

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        //setContentView(R.layout.activity_main)

    }

}