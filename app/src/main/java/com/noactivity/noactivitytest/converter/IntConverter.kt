package com.noactivity.noactivitytest.converter

import android.widget.TextView
import androidx.databinding.InverseMethod

object IntConverter {

    /**
     * 整数型を文字列に変換
     */
    @InverseMethod("stringToInt")
    @JvmStatic fun intToString(value: Int): String
    {
        return String.format("%d", value)
    }

    /**
     * 文字列を整数型に変換
     */
    @JvmStatic fun stringToInt(value: String?): Int
    {
        return kotlin.runCatching {  value?.toInt() }.getOrNull()?: 0
    }

}