package com.noactivity.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    /**
     * プログラム起動
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)

        // active_main.xmlを表示
        setContentView(R.layout.activity_main)

    }

}