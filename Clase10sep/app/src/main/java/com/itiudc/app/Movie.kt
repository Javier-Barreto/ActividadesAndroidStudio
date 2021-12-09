package com.itiudc.app

import android.util.Log

class Movie(
    val title: String,
    val duration: Float,
    val director: String,
    val year: Int,
    val review: String)

    {
        fun play(){
            Log.i("Javier", "$title is playing")
        }

    }
}