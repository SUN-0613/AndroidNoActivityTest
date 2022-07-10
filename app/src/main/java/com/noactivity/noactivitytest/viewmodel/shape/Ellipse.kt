package com.noactivity.noactivitytest.viewmodel.shape

import MyApp.MyApplication
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.graphics.drawable.shapes.Shape
import com.noactivity.noactivitytest.MainActivity


class Ellipse
{

    /**
     * 円のイメージを作成
     * https://little-strange.hatenablog.com/entry/2019/09/16/190748
     */
    fun create(size: Float, stroke: Int): StateListDrawable
    {

        // dp -> pixel に変換
        var dp2px = MainActivity.Instance!!.getResources().displayMetrics
        var res = StateListDrawable()
        var gradient = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        gradient.shape = 1  // ellipse
        gradient.gradientType = GradientDrawable.RADIAL_GRADIENT
        gradient.gradientRadius = size * dp2px.density
        gradient.setGradientCenter(0f ,0f)
        gradient.cornerRadius = 10f * dp2px.density
        gradient.setStroke((stroke * dp2px.density).toInt(),
                            Color.parseColor("#00FF00"))
        gradient.setSize((size * dp2px.density).toInt(), (size * dp2px.density).toInt())

        res.addState(intArrayOf(), gradient)

        return res

    }

}