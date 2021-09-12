package com.example.memeapp.repository

import android.util.Log
import com.example.memeapp.networking.Status
import com.example.memeapp.networking.API

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Respository {

    fun getMemes()=wrampWithFlow { API.apiService.getMemes() }



    private fun <T> wrampWithFlow(function: suspend () -> Response<T> )
            : Flow<Status<T?>>
        = flow {
            emit(Status.Loading)
            try{
                val result = function()
                if (result.isSuccessful)
                    emit(Status.Success(result.body()))
                else
                    emit(Status.Error(result.message()))
                Log.i("hh", Status.Error(result.message()).toString())

            } catch (e:Exception){
                emit(Status.Error(e.message.toString()))
                Log.i("hh",e.message.toString())
            }
        }


}

