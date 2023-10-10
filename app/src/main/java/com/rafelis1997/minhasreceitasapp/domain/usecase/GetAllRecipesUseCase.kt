package com.rafelis1997.minhasreceitasapp.domain.usecase

import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository

class GetAllRecipesUseCase constructor(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke() = repository.getAll()
}