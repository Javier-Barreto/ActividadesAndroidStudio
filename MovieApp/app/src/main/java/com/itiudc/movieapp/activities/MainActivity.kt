package com.itiudc.movieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.itiudc.movieapp.R
import com.itiudc.movieapp.fragments.MovieListFragment
import com.itiudc.movieapp.fragments.MovieProfileFragment
import com.itiudc.movieapp.models.Movie

class MainActivity : AppCompatActivity(), MovieListFragment.MovieSelectListener {

    private lateinit var movieProfileFragment: MovieProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieProfileFragment = supportFragmentManager.findFragmentById(R.id.movie_profile) as MovieProfileFragment

    }

    override fun onMovieSelected(movie: Movie) {
        Log.i("jav", "Movie loaded on MainActivity: ${movie.title}")
        movieProfileFragment.set(movie)
    }
}