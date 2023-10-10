package com.rafelis1997.minhasreceitasapp.presentation.recipe

import com.rafelis1997.minhasreceitasapp.domain.model.RecipeDomain

sealed interface RecipeState {
    data object Loading : RecipeState
    data object Empty : RecipeState
    data class Success(val recipe: List<RecipeDomain>) : RecipeState
    data class Error(val message: String) : RecipeState
}