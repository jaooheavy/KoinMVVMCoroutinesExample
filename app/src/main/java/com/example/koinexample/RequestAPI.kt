package com.example.koinexample

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class RequestAPI() {

    suspend fun getFromAPIData(int: Int):String{
        delay(3000)
        return "Você cliclou $int vez"
    }

}