package com.rafelis1997.minhasreceitasapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias IngredientDomain = Ingredient

@Entity
data class Ingredient(
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "idRecipe")
    val idRecipe: Int,
)