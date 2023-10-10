package com.rafelis1997.minhasreceitasapp.domain.model

import androidx.room.Embedded
import androidx.room.Relation

typealias FullRecipeDomain = FullRecipe

data class FullRecipe(
    val recipe: RecipeDomain,
    val ingredient: List<Ingredient>,
    val prepareMode: List<PrepareMode>,
)