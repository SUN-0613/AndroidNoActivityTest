package com.noactivity.noactivitytest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

    /**
     * 並列処理実行イベント
     */
    fun OnCoroutine()
    {

        // 並列処理
        viewModelScope.launch(Dispatchers.Default)
        {

            delay(5000)

            counter.postValue(1000)

        }

    }

}