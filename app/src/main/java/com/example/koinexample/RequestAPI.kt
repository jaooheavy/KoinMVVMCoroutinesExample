package com.example.koinexample

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class RequestAPI() {

    suspend fun getFromAPIData(int: Int):String{
        delay(1000)
        return "Você clicou $int vez"
    }

}