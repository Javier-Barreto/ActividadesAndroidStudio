package com.itiudc.gamelist.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameViewModel(private val initialScore: Int) : ViewModel() {
    private val _score: MutableLiveData<Int> = MutableLiveData()
    val score: LiveData<Int>
        get() = _score

    init {
        _score.value = initialScore
    }

    fun ChangeScore(value: Int) {
        _score.value = _score.value?.plus(value)
    }
}

class GameViewModelFactory(private val initialScore: Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GameViewModel(initialScore) as T
    }

}