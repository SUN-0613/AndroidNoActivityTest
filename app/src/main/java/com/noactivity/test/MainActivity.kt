package com.noactivity.test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

// Binding
import androidx.databinding.DataBindingUtil
import com.noactivity.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    /**
     * activity_main.xmlのViewModel
     */
    private val _mainViewModel: MainViewModel by viewModels()

    /**
     * プログラム起動
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)

        // view.DataContext取得
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // xmlの<data><variable>で指定した名称を使用
        binding.viewmodel = _mainViewModel

    }

}