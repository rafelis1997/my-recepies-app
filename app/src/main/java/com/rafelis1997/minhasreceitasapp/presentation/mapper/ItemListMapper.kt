package com.rafelis1997.minhasreceitasapp.presentation.mapper

import com.rafelis1997.minhasreceitasapp.domain.model.IngredientDomain
import com.rafelis1997.minhasreceitasapp.domain.model.PrepareModeDomain
import com.rafelis1997.minhasreceitasapp.presentation.ItemListModel

fun IngredientDomain.toModel() = ItemListModel(
    id = id,
    name = name,
)

fun List<IngredientDomain>.toModelIngredient() = map {
    it.toModel()
}

fun PrepareModeDomain.toModel() = ItemListModel(
    id = id,
    name = name,
)

fun List<PrepareModeDomain>.toModelPrepareModel() = map {
    it.toModel()
}