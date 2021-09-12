package com.example.memeapp.viewModel

import androidx.lifecycle.*
import com.example.memeapp.data.Memes
import com.example.memeapp.networking.Status
import com.example.memeapp.repository.Respository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val respository=Respository()
    val memes=MutableLiveData<Status<Memes?>?>()



    init {
        getRandomMeme()
    }
         fun getRandomMeme(){



        viewModelScope.launch {
            respository.getMemes().collect {

                memes.postValue(it)
            }
        }
    }

}