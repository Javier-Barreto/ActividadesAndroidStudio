package com.itiudc.movieapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itiudc.movieapp.models.Movie
import com.itiudc.movieapp.services.movieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel() {
    private var _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>>
        get() = _movies

    init{
        viewModelScope.launch {
            _movies.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Movie> {
        return withContext(Dispatchers.IO){
            val movies: MutableList<Movie> = movieService.getPopular().results

            movies
        }
    }
}