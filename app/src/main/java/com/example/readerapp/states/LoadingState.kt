package com.example.readerapp.states

import com.example.readerapp.enums.Status

data class LoadingState(val status: Status, val message: String? = null){
    companion object{
        val Idle = LoadingState(status = Status.IDLE)
        val Success = LoadingState(status = Status.SUCCESS)
        val Loading = LoadingState(status = Status.LOADING)
        val Failed = LoadingState(status = Status.FAILED)
    }
}
