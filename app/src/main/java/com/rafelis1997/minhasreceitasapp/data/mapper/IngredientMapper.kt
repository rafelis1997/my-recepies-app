package com.rafelis1997.minhasreceitasapp.data.mapper

import com.rafelis1997.minhasreceitasapp.data.entity.IngredientEntity
import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain

fun IngredientDomain.toEntity() = IngredientEntity(
    id = id,
    name = name,
    idRecipe = idRecipe
)

fun IngredientEntity.toDomain() = IngredientDomain(
    id = id,
    name = name,
    idRecipe = idRecipe
)