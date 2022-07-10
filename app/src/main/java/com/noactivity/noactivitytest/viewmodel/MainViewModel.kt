package com.noactivity.noactivitytest.viewmodel

import MyApp.MyApplication
import android.graphics.drawable.StateListDrawable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noactivity.noactivitytest.viewmodel.HidConnect.UsbHid
import com.noactivity.noactivitytest.viewmodel.shape.Ellipse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {


    /**
     * ボタンタップ回数プロパティ
     */
    var counter = MutableLiveData<Int>(10)

    /**
     * UI表示メッセージプロパティ
     */
    var message = MutableLiveData<String>("Hello world!!")

    /**
     * 円イメージ
     */
    var circle = MutableLiveData<StateListDrawable>()

    /**
     * USB HIDデバイス
     */
    private lateinit var usbHid: UsbHid

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

        viewModelScope.launch(Dispatchers.Default)
        {


            delay(2000)

            counter.postValue(500)

        }

    }

    fun OnDrawCircle()
    {

        viewModelScope.launch(Dispatchers.Default)
        {

            circle.postValue(Ellipse().create(135f, 2))

            delay(3000)

            circle.postValue(Ellipse().create(80f, 5))

        }



    }

}