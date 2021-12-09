package com.itiudc.gamelist.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.itiudc.gamelist.R
import com.itiudc.gamelist.databinding.ActivityDetailBinding
import com.itiudc.gamelist.models.Game
import com.itiudc.gamelist.models.GameViewModel
import com.itiudc.gamelist.models.GameViewModelFactory

class DetailActivity : AppCompatActivity() {
    companion object {
        const val GAME_KEY = "game_item"
        const val GAME_IMAGE = "game_image"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel : GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)


        val bundle: Bundle? = intent.extras

        if (bundle != null) {
            val game = bundle.getParcelable<Game>(GAME_KEY)
            val image = bundle.getInt(GAME_IMAGE)

            viewModel = ViewModelProvider(this, GameViewModelFactory(game?.score ?: 0)).get(GameViewModel::class.java)
            viewModel.score.observe(this){
                it->
                binding.score.text = it.toString()

                ChangeValidation(it)
            }

            binding.name.text = game?.name
            binding.description.text = game?.description

            val genreIcon = when (game?.genre) {
                Game.GameGenre.SHOOTER -> R.drawable.ic_shooter_foreground
                Game.GameGenre.ADVERTURE -> R.drawable.ic_adventure_foreground
                Game.GameGenre.SPOTRS -> R.drawable.ic_sports_foreground
                Game.GameGenre.STRATEGY -> R.drawable.ic_strategy_foreground
                Game.GameGenre.RACING -> R.drawable.ic_racing_foreground
                else -> R.drawable.ic_other_f
            }

            binding.genreImage.setImageResource(genreIcon)
            binding.genreName.text = game?.genre?.name ?: ""
            binding.isFree.text = if (game?.isFree == true) "Free" else "NOT free"
            binding.webpage.text = game?.webPage
            binding.imageProfile.setImageResource(image)

            binding.minus.setOnClickListener() {
                viewModel.ChangeScore(-1)
            }

            binding.plus.setOnClickListener() {
                viewModel.ChangeScore(1)
            }
        }
    }

    private fun ChangeValidation(score: Int) {
        binding.minus.visibility = View.INVISIBLE
        binding.plus.visibility = View.INVISIBLE

        if (score < 5)
            binding.plus.visibility = View.VISIBLE
        if (score > 0)
            binding.minus.visibility = View.VISIBLE
    }
}


