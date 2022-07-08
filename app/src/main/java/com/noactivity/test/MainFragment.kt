package com.noactivity.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment : Fragment()
{

    private var listener: OnTestFragmentMainListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //return super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.test_fragment_main, container, false)
        val addFragment = view.findViewById<>()

    }

    interface OnTestFragmentMainListener{
        fun onTestFragmentMainAddFragment()
    }

}