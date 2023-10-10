package com.rafelis1997.minhasreceitasapp.data.repository

import com.rafelis1997.minhasreceitasapp.data.dao.RecipeDao
import com.rafelis1997.minhasreceitasapp.data.mapper.toDomain
import com.rafelis1997.minhasreceitasapp.data.mapper.toEntity
import com.rafelis1997.minhasreceitasapp.domain.model.FullRecipeDomain
import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain
import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain
import com.rafelis1997.minhasreceitasapp.domain.model.RecipeDomain
import com.rafelis1997.minhasreceitasapp.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(private val dao: RecipeDao) : RecipeRepository {
    override suspend fun getAll(): Flow<List<RecipeDomain>> = withContext(Dispatchers.IO) {
        dao.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun insert(recipe: RecipeDomain) = withContext(Dispatchers.IO) {
        dao.insert(recipe.toEntity())
    }

    override suspend fun getRecipeWIthIngredientsAndPrepareMode(idRecipe: Int): FullRecipeDomain =
        withContext(Dispatchers.IO) {
            dao.getRecipeWithIngredientsAndPrepareMode(idRecipe).toDomain()
        }

    override suspend fun updateIngredient(ingredient: IngredientDomain) = withContext(Dispatchers.IO) {
        dao.updateIngredient(
            ingredient.toEntity()
        )
    }

    override suspend fun updatePrepareMode(prepareMode: PrepareModeDomain)= withContext(Dispatchers.IO) {
        dao.updatePrepareMode(
            prepareMode.toEntity()
        )
    }

    override suspend fun insertIngredient(ingredient: IngredientDomain) = withContext(Dispatchers.IO) {
        dao.insert(
            ingredient.toEntity()
        )
    }

    override suspend fun insertPrepareMode(prepareMode: PrepareModeDomain) = withContext(Dispatchers.IO) {
        dao.insert(
            prepareMode.toEntity()
        )
    }
}