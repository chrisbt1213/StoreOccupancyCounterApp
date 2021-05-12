package com.timercountercs4080

import androidx.lifecycle.ViewModel

private const val TAG = "CounterViewModel"

class CounterViewModel : ViewModel() {

    var counter = 0

    var tvCounter = R.id.tv_counter

    fun increment(){
        counter+=1

        tvCounter = counter
    }

    fun decrement(){
        counter-=1

        if (counter < 0){
            counter = 0
        }

        tvCounter = counter
    }

    fun reset(){
        counter=0

        tvCounter = counter
    }
}