package com.noactivity.noactivitytest.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.MutableLiveData

/**
 * Canvas.View
 * https://blog.recruit.co.jp/rmp/mobile/remember_canvas1/
 * https://techacademy.jp/magazine/4771
 */
class CustomCanvas: View
{

    public var CenterX = MutableLiveData<Float>()
    public var CenterY = MutableLiveData<Float>()

    public var ColorA = MutableLiveData<Int>()
    public var ColorR = MutableLiveData<Int>()
    public var ColorG = MutableLiveData<Int>()
    public var ColorB = MutableLiveData<Int>()

    /**
     * 円の半径
     */
    public var Radius = MutableLiveData<Float>()

    public var Thickness = MutableLiveData<Float>()

    var isDraw = false
    public var IsDraw: Boolean
    get() { return isDraw }
    set(value)
    {
        isDraw = value
        invalidate()    // call onDraw()
    }

    /**
     * 描画設定
     */
    private val paint = Paint()

    constructor(context: Context): super(context)
    { }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    { }

    /**
     * 描画イベント
     */
    override fun onDraw(canvas: Canvas?)
    {

        super.onDraw(canvas)

        if (IsDraw)
        {

            // 塗りつぶしなし
            paint.setStyle(Paint.Style.STROKE)
            paint.strokeWidth += Thickness.value!!

            //Alpha.value!!
            paint.setColor(Color.argb(ColorA.value!!, ColorR.value!!, ColorG.value!!, ColorB.value!!))
            canvas?.drawCircle(CenterX.value!!, CenterY.value!!, Radius.value!!, paint)

        }

    }

}