package com.itiudc.gamelist.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.LinearLayoutBindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.gamelist.R
import com.itiudc.gamelist.activities.detail.DetailActivity
import com.itiudc.gamelist.databinding.ActivityMainBinding
import com.itiudc.gamelist.models.Game

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val gameList = mutableListOf<Game>(
            Game(
                1,
                "Back4Blood",
                Game.GameGenre.SHOOTER,
                "Zombies and More zombies",
                false,
                null,
                4
            ),
            Game(
                2,
                "Medieval 2 Total War",
                Game.GameGenre.STRATEGY,
                "A medieval Strategy game by TotalWar",
                false,
                null,
                5
            ),
            Game(3, "Minecraft", Game.GameGenre.ADVERTURE, "Build and explore!", false, null, 3),
            Game(4, "Warframe", Game.GameGenre.SHOOTER, "It's warframe boy!", true, null, 2)
        )

        val gameListAdapter = GameListAdapter(gameList)
        binding.gameList.layoutManager = LinearLayoutManager(this)
        binding.gameList.adapter = gameListAdapter
        gameListAdapter.onGameClick = {
            val intent = Intent(this, DetailActivity::class.java).apply {
                val imageToSend = when(it.id){
                    1 -> R.drawable.back4blood
                    2 -> R.drawable.medieval2totalwar
                    3 -> R.drawable.minecraft
                    4 -> R.drawable.warframe
                    else -> R.drawable.ic_launcher_background
                }
                putExtra(DetailActivity.GAME_KEY, it)
                putExtra(DetailActivity.GAME_IMAGE, imageToSend)
            }
            startActivity(intent)
        }
    }
}