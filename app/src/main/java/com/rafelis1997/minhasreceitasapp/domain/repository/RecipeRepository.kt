package com.rafelis1997.minhasreceitasapp.domain.repository

import com.rafelis1997.minhasreceitasapp.domain.model.FullRecipeDomain
import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain
import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain
import com.rafelis1997.minhasreceitasapp.domain.model.RecipeDomain
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getAll(): Flow<List<RecipeDomain>>
    suspend fun insert(recipe: RecipeDomain)
    suspend fun insertIngredient(ingredient: IngredientDomain)
    suspend fun insertPrepareMode(prepareMode: PrepareModeDomain)
    suspend fun getRecipeWIthIngredientsAndPrepareMode(idRecipe: Int) : FullRecipeDomain
    suspend fun updateIngredient(ingredient: IngredientDomain)
    suspend fun updatePrepareMode(prepareMode: PrepareModeDomain)

}
