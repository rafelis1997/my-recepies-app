package com.rafelis1997.minhasreceitasapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.rafelis1997.minhasreceitasapp.data.entity.FullRecipeEntity
import com.rafelis1997.minhasreceitasapp.data.entity.Ingredient
import com.rafelis1997.minhasreceitasapp.data.entity.PrepareMode
import com.rafelis1997.minhasreceitasapp.data.entity.Recipe
import com.rafelis1997.minhasreceitasapp.data.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("Select * FROM recipe")
    fun getAll(): Flow<List<Recipe>>

    @Insert
    fun insert(recipe: RecipeEntity)

    @Insert
    fun insert(ingredient: Ingredient)

    @Insert
    fun insert(prepareMode: PrepareMode)

    @Transaction
    @Query("SELECT * FROM recipe WHERE id = :recipeId")
    fun getRecipeWithIngredientsAndPrepareMode(recipeId: Int) : FullRecipeEntity

    @Update
    fun updateIngredient(ingredient: Ingredient)

    @Update
    fun updatePrepareMode(prepareMode: PrepareMode)
}