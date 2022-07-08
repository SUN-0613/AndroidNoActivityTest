package com.noactivity.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * メイン画面.ViewModel
 */
class MainViewModel : ViewModel()
{

    var counter: MutableLiveData<Int> = MutableLiveData(11)

    /**
     * Button.Tappedイベント
     */
    fun onButtonTapped(text: String)
    {

        var num: Int = counter.value!!

        when (text)
        {

            "plus" ->
            {
                num += 1
            }

            "minus" ->
            {
                num -= 1
            }

            else ->
            {
                num = 0
            }

        }

        counter.value = num

    }

}