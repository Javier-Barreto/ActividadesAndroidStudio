package com.itiudc.movieapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.movieapp.adapters.MovieListAdapter
import com.itiudc.movieapp.databinding.FragmentMovieListBinding
import com.itiudc.movieapp.models.Movie
import com.itiudc.movieapp.viewModels.MovieViewModel
import java.lang.ClassCastException

class MovieListFragment : Fragment() {

    public interface MovieSelectListener{
        fun onMovieSelected(movie: Movie)
    }

    private lateinit var movieSelectListener: MovieSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)

        movieSelectListener = try {
            context as MovieSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context must implemet MovieSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        val binding = FragmentMovieListBinding.inflate(inflater, container, false)

        movieViewModel.movies.observe(viewLifecycleOwner, Observer<MutableList<Movie>>{
            movies ->
            val adapter = MovieListAdapter(movies)

            adapter.onClickItem = {
                Log.i("jav", "Movie ${it.title}")
                movieSelectListener.onMovieSelected(it)
            }

            binding.recyclerMovieList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerMovieList.adapter = adapter
        })



        return binding.root
    }
}