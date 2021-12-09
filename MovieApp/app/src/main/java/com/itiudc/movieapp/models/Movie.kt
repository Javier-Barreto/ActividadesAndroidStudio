package com.itiudc.movieapp.models

import java.util.*

class Movie(
    val id: Int,
    val title: String,
    val original_title: String,
    val original_title_roaminsed: String,
    val description: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val running_time: String,
    val rt_score: String,
    val people: Array<String>,
    val species: Array<String>,
    val locations: Array<String>,
    val vehicles: Array<String>,
    val url: String

    /*val name: String,
    val height: Int,
    val mass: Int,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val films: Array<String>,
    val species: Array<String>,
    val vehicles: Array<String>,
    val starships: Array<String>,
    val created: String,
    val edited: String,
    val url: String*/

    /*val id: Int,
    val language: String,
    val original_title: String,
    val overview: String,
    val popularty: Double,
    val release_date: String,
    val poster_path: String*/
) {

}