package com.ex.homework4_5month

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var count = 0;

    val counterData = MutableLiveData<Int>()
    val colorData = MutableLiveData<Int>()

    fun increment() {
        counterData.value = count++
        changeColor()
    }

    fun decrement() {
        counterData.value = count--

    }

    fun showResult(context:Context) {
        if (counterData.value == 10) {
            Toast.makeText(context, "Поздравляем", Toast.LENGTH_SHORT).show()
        }

    }
    fun changeColor(){
        if (counterData.value == 15)
            colorData.value = R.color.green
        else{
            colorData.value =  (R.color.black)
        }
    }


}

