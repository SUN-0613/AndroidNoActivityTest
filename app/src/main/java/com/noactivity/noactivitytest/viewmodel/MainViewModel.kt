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

    var CenterX = MutableLiveData<Float>()
    var CenterY = MutableLiveData<Float>()
    var ColorA = MutableLiveData<Int>()
    var ColorR = MutableLiveData<Int>()
    var ColorG = MutableLiveData<Int>()
    var ColorB = MutableLiveData<Int>()
    var Radius = MutableLiveData<Float>()
    var Thickness = MutableLiveData<Float>()
    var IsDraw = MutableLiveData<Boolean>(false)

    var Message = MutableLiveData<String>()

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

            Message.postValue("No.1")

            IsDraw.postValue(false)
            Radius.postValue(100f)
            Thickness.postValue(10f)
            CenterX.postValue(0f)
            CenterY.postValue(0f)
            ColorA.postValue(100)
            ColorR.postValue(0xFF)
            ColorG.postValue(0x00)
            ColorB.postValue(0x00)
            IsDraw.postValue(true)

            delay(3000)

            Message.postValue("No.2")

            IsDraw.postValue(false)
            Radius.postValue(80f)
            Thickness.postValue(30f)
            CenterX.postValue(250f)
            CenterY.postValue(300f)
            ColorA.postValue(50)
            ColorR.postValue(0x00)
            ColorG.postValue(0x00)
            ColorB.postValue(0xFF)
            IsDraw.postValue(true)


            delay(3000)

            Message.postValue("No.3")

            IsDraw.postValue(false)
            Radius.postValue(120f)
            Thickness.postValue(30f)
            CenterX.postValue(400f)
            CenterY.postValue(400f)
            ColorA.postValue(0xFF)
            ColorR.postValue(0x00)
            ColorG.postValue(0xFF)
            ColorB.postValue(0x00)
            IsDraw.postValue(true)

            delay(1000)
            IsDraw.postValue(false)

            Message.postValue("Finish")

        }

    }

}