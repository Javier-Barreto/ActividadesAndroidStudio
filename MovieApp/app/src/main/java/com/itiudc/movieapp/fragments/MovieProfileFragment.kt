package com.itiudc.movieapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itiudc.movieapp.R
import com.itiudc.movieapp.models.Movie

class MovieProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_profile, container, false)
    }

    fun set(movie: Movie){
        Log.i("jav", "Movie loaded on MovieProfile Fragment: ${movie.title}")
    }
}