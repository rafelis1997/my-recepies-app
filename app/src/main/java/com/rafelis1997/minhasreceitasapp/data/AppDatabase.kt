package com.rafelis1997.minhasreceitasapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafelis1997.minhasreceitasapp.data.dao.RecipeDao
import com.rafelis1997.minhasreceitasapp.data.entity.IngredientEntity
import com.rafelis1997.minhasreceitasapp.data.entity.PrepareModeEntity
import com.rafelis1997.minhasreceitasapp.data.entity.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        IngredientEntity::class,
        PrepareModeEntity::class,
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}