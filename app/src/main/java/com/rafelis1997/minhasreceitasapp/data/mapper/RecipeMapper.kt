package com.rafelis1997.minhasreceitasapp.data.mapper

import com.rafelis1997.minhasreceitasapp.data.entity.RecipeEntity
import com.rafelis1997.minhasreceitasapp.domain.model.RecipeDomain

fun RecipeDomain.toEntity() = RecipeEntity(
    id = id,
    name = name,
    prepareTime = prepareTime
)

fun RecipeEntity.toDomain() = RecipeDomain(
    id = id,
    name = name,
    prepareTime = prepareTime
)