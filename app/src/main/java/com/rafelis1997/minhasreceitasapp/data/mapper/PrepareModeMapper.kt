package com.rafelis1997.minhasreceitasapp.data.mapper

import com.rafelis1997.minhasreceitasapp.data.entity.PrepareModeEntity
import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain

fun PrepareModeDomain.toEntity() = PrepareModeEntity(
    id = id,
    name = name,
    idRecipe = idRecipe
)

fun PrepareModeEntity.toDomain() = PrepareModeDomain(
    id = id,
    name = name,
    idRecipe = idRecipe
)