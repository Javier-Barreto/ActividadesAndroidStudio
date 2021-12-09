package com.itiudc.apitest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class characterViewModel : ViewModel() {
    private var _characters = MutableLiveData<MutableList<character>>()
    val characters: LiveData<MutableList<character>>
        get() = _characters

    init {
        viewModelScope.launch {
            _characters.value
        }
    }

    private  suspend fun fetch(): MutableList<character>{
        return withContext(Dispatchers.IO){
            val characters: MutableList<character> = characterS.getCharacters().name

            characters
        }
    }
}