package com.noactivity.test

import androidx.lifecycle.ViewModel

/**
 * メイン画面.ViewModel
 */
class MainViewModel : ViewModel()
{

    val MessageText: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun Tapped()
    {
        MessageText.value = "Hello world!"
    }


}