package com.noactivity.noactivitytest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var counter = MutableLiveData<Int>(10)

    var message = MutableLiveData<String>("Hello world!!")

    /**
     * Button.Tappedイベント
     */
    fun OnButtonTapped(tag: TagEnum)
    {

        var value: Int = counter.value!!

        when (tag)
        {

            TagEnum.Plus -> { value += 1 }
            TagEnum.Minus -> { value -= 1 }
            else -> { value = 0 }

        }

        counter.value = value

    }

}