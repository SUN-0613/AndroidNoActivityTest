package com.noactivity.noactivitytest.viewmodel

import MyApp.MyApplication
import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.hardware.input.InputManager
import android.os.SystemClock
import android.util.Log
import android.view.InputDevice
import android.view.InputEvent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noactivity.noactivitytest.MainActivity
import com.noactivity.noactivitytest.viewmodel.HidConnect.UsbHid
import com.noactivity.noactivitytest.viewmodel.shape.Ellipse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.reflect.InvocationTargetException
import java.util.concurrent.TimeUnit

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

    fun sendTap()
    {

        viewModelScope.launch(Dispatchers.Default)
        {
            sendTapEvent()
        }

    }

    /**
     * Tapイベントを発行する
     */
    private fun sendTapEvent()
    {

        val pointX = 100f
        val pointY = 100f

        val downTime = SystemClock.uptimeMillis()
        val eventTime = SystemClock.uptimeMillis() + 1000

        Message.postValue("event1")

        val event1 = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, pointX, pointY, 0)
        event1.source = InputDevice.SOURCE_MOUSE
        injectInputEvent(event1)

        TimeUnit.SECONDS.sleep(1)

        Message.postValue("event2")

        val event2 = MotionEvent.obtain(eventTime + 100, eventTime + 2000, MotionEvent.ACTION_UP, pointX, pointY, 0)
        event2.source = InputDevice.SOURCE_MOUSE
        injectInputEvent(event2)

        Message.postValue("fin")

    }

    /**
     * 入力イベント
     */
    private fun injectInputEvent(event: InputEvent)
    {

        try
        {

            //val inputManager = InputManager::class.java.getMethod("getInstance").invoke(null) as InputManager
            val inputManager = MainActivity.getInputManager()
            val injectInputEventMethod = InputManager::class.java.getMethod("injectInputEvent", InputEvent::class.java, Int::class.javaPrimitiveType)

            injectInputEventMethod.invoke(inputManager, event, 2)

            println("Tap OK")

            Message.postValue("Tap OK")

        }
        catch (e: NoSuchMethodException)
        {
            e.printStackTrace()
        }
        catch (e: IllegalAccessException)
        {
            e.printStackTrace()
        }
        catch (e: IllegalArgumentException)
        {
            e.printStackTrace()
        }
        catch (e: InvocationTargetException)
        {
            e.printStackTrace()
        }

    }

}