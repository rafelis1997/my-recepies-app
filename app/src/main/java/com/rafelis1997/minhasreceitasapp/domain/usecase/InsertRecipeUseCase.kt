package com.rafelis1997.minhasreceitasapp.domain.usecase

import com.rafelis1997.minhasreceitasapp.domain.model.RecipeDomain
import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository

class InsertRecipeUseCase constructor(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(recipe: RecipeDomain) = repository.insert(recipe)
}