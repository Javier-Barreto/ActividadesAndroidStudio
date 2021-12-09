package com.itiudc.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val CharViewModel = ViewModelProvider(this).get(characterViewModel::class.java)

        CharViewModel.characters.observe(viewLife, Observer<MutableList<character>>{
            characters ->

            Log.i("asd", "${characters}")
        })

        /*movieViewModel.movies.observe(viewLifecycleOwner, Observer<MutableList<Movie>>{
            movies ->
            val adapter = MovieListAdapter(movies)

            adapter.onClickItem = {
                Log.i("jav", "Movie ${it.original_title}")
                movieSelectListener.onMovieSelected(it)
            }

            binding.recyclerMovieList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerMovieList.adapter = adapter
        })*/
    }
}