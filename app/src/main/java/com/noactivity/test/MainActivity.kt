package com.noactivity.test

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noactivity.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private val _viewmodel: MainViewModel by viewModels()

    /**
     * プログラム起動
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)

        // active_main.xmlを表示
        setContentView(R.layout.activity_main)

        // DataBinding準備
        var binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ViewModel紐づけ
        binding.viewmodel = _viewmodel


    }

}