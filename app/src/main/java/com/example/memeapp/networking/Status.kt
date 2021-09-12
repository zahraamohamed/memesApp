package com.example.memeapp.networking

sealed class Status<out T>{
    object Loading : Status<Nothing>()
    data class Error(val message: String) : Status<Nothing>()
    data class Success<T>(val data: T): Status<T>()

    fun toData(): T? = if(this is Success) data else null
}


