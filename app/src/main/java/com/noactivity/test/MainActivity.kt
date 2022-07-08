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
     * プログラム起動
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)

        val view = R.layout.activity_main

        setContentView(view)

    }

}