package com.itiudc.movieapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itiudc.movieapp.R
import com.itiudc.movieapp.databinding.MovieListItemBinding
import com.itiudc.movieapp.models.Movie

class MovieListAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){

    lateinit var onClickItem: (Movie) -> Unit

    inner class ViewHolder(private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            Glide
                .with(binding.root)
                .load("https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Yasuo_0.jpg")
                //.load("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.movieImage)

            binding.root.setOnClickListener(){
                if(::onClickItem.isInitialized)
                    onClickItem(movie)
                else
                    Log.i("jav", "onMovieClick event is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

}