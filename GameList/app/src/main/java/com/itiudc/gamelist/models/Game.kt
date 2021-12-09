package com.itiudc.gamelist.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Game(val id: Int,
           val name: String,
           val genre: GameGenre,
           val description: String,
           val isFree: Boolean,
           val webPage: String?,
           val score: Int
           ) : Parcelable {

    enum class GameGenre(){
        SHOOTER, ADVERTURE, SPOTRS, RACING, STRATEGY, OTHER
    }
}