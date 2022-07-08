package com.noactivity.noactivitytest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var counter = MutableLiveData<Int>(10)

    var message = MutableLiveData<String>("Hello world!!")

}