package com.rafelis1997.minhasreceitasapp.domain.usecase

import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain
import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository

class InsertPrepareModeUseCase constructor(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(prepareMode: PrepareModeDomain) =
        repository.insertPrepareMode(prepareMode)
}