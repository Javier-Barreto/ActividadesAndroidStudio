package com.itiudc.gamelist.activities.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itiudc.gamelist.databinding.GameListItemBinding
import com.itiudc.gamelist.models.Game

class GameListAdapter(private val gameList: List<Game>) : RecyclerView.Adapter<GameListAdapter.Viewholder>(){
    lateinit var onGameClick: (Game) -> Unit

    inner class Viewholder(private val binding: GameListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game){
            binding.gameId.text = game.id.toString()
            binding.name.text = game.name
            binding.genre.text = game.genre.name
            binding.root.setOnClickListener(){
                if(::onGameClick.isInitialized)
                    onGameClick(game)
                else
                    Log.i("javGameAdapter", "The onGameClick from GameListAdapter is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = GameListItemBinding.inflate(LayoutInflater.from(parent.context))

        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(gameList[position])
    }

    override fun getItemCount(): Int {
        return gameList.count()
    }
}