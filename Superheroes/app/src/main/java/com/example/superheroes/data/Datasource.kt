package com.example.superheroes.data

import androidx.compose.ui.res.stringResource
import com.example.superheroes.R
import com.example.superheroes.model.Superhero

object Datasource {
    val Superheroes = listOf(
            Superhero(R.string.hero1_name, R.string.hero1_description, R.drawable.android_superhero1),
            Superhero(R.string.hero2_name, R.string.hero2_description, R.drawable.android_superhero2),
            Superhero(R.string.hero3_name, R.string.hero3_description, R.drawable.android_superhero3),
            Superhero(R.string.hero4_name, R.string.hero4_description, R.drawable.android_superhero4),
            Superhero(R.string.hero5_name, R.string.hero5_description, R.drawable.android_superhero5),
            Superhero(R.string.hero6_name, R.string.hero6_description, R.drawable.android_superhero6),
    )
}