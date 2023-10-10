package com.rafelis1997.minhasreceitasapp.domain.usecase

import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository

class GetFullRecipeUseCase constructor(
    private val repository: RecipeRepository,
) {
    suspend operator fun invoke(idRecipe: Int) =
        repository.getRecipeWIthIngredientsAndPrepareMode(idRecipe)
}