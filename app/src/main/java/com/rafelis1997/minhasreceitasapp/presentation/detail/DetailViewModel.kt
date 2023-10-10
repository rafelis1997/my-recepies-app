package com.rafelis1997.minhasreceitasapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.rafelis1997.minhasreceitasapp.data.db
import com.rafelis1997.minhasreceitasapp.data.repository.RecipeRepositoryImpl
import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain
import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain
import com.rafelis1997.minhasreceitasapp.domain.usecase.GetAllRecipesUseCase
import com.rafelis1997.minhasreceitasapp.domain.usecase.GetFullRecipeUseCase
import com.rafelis1997.minhasreceitasapp.domain.usecase.InsertIngredientUseCase
import com.rafelis1997.minhasreceitasapp.domain.usecase.InsertPrepareModeUseCase
import com.rafelis1997.minhasreceitasapp.domain.usecase.InsertRecipeUseCase
import com.rafelis1997.minhasreceitasapp.presentation.mapper.toModelIngredient
import com.rafelis1997.minhasreceitasapp.presentation.mapper.toModelPrepareModel
import com.rafelis1997.minhasreceitasapp.presentation.recipe.RecipeState
import com.rafelis1997.minhasreceitasapp.presentation.recipe.RecipesViewModel
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getFullRecipeUseCase: GetFullRecipeUseCase,
    private val insertIngredientUseCase: InsertIngredientUseCase,
    private val insertPrepareModeUseCase: InsertPrepareModeUseCase,
) : ViewModel() {

    fun getRecipeWithIngredientsAndPrepareMode(idRecipe: Int): LiveData<DetailState> = liveData {
        emit(DetailState.Loading)
        val state = try {
            val recipe = getFullRecipeUseCase(idRecipe)

            DetailState.Success(
                ingredients = recipe.ingredient.toModelIngredient(),
                prepareMode = recipe.prepareMode.toModelPrepareModel(),
            )
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            DetailState.Error(e.message.toString())
        }
        emit(state)
    }

    fun insertPrepareModeOrIngredient(
        typeInsert: String,
        name: String,
        idRecipe: Int,
    ) = viewModelScope.launch {
        if (typeInsert == "INGREDIENT") {
            insertIngredientUseCase(IngredientDomain(name = name, idRecipe = idRecipe))
        } else {
            insertPrepareModeUseCase(PrepareModeDomain(name = name, idRecipe = idRecipe))
        }
    }


    fun updateIngredient() {
        //@TODO realizar o update do ingredient
    }

    fun removeIngredient() {
        //@TODO realizar a exclusao do ingredient
    }

    fun updatePrepareMode() {
        //@TODO realizar o update do modo de preparo
    }

    fun removePrepareMode() {
        //@TODO realizar o update do modo de preparo
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras,
        ): T {
            val application =
                checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
            val repository = RecipeRepositoryImpl(application.db.recipeDao())
            return DetailViewModel(
                getFullRecipeUseCase = GetFullRecipeUseCase(repository),
                insertIngredientUseCase = InsertIngredientUseCase(repository),
                insertPrepareModeUseCase = InsertPrepareModeUseCase(repository),
            ) as T
        }
    }
}