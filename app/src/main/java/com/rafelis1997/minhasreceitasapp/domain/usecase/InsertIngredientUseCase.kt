package com.rafelis1997.minhasreceitasapp.domain.usecase

import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain
import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository

class InsertIngredientUseCase constructor(
    private val repository: RecipeRepository,
) {
    suspend operator fun invoke(ingredient: IngredientDomain) = repository.insertIngredient(ingredient)
}