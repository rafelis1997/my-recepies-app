package com.rafelis1997.minhasreceitasapp.data.mapper

import com.rafelis1997.minhasreceitasapp.data.entity.FullRecipeEntity
import com.rafelis1997.minhasreceitasapp.domain.model.FullRecipeDomain

fun FullRecipeDomain.toEntity() = FullRecipeEntity(
    recipe = recipe.toEntity(),
    ingredient = ingredient.map {
                                it.toEntity()
    },
    prepareMode = prepareMode.map {
                                  it.toEntity()
    },
)

fun FullRecipeEntity.toDomain() = FullRecipeDomain(
    recipe = recipe.toDomain(),
    ingredient = ingredient.map {
                                it.toDomain()
    },
    prepareMode = prepareMode.map {
                                  it.toDomain()
    },
)