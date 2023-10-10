package com.rafelis1997.minhasreceitasapp.presentation.detail

import com.rafelis1997.minhasreceitasapp.presentation.ItemListModel

sealed interface DetailState {
    data object Loading : DetailState
    data class Success(
        val ingredients: List<ItemListModel>,
        val prepareMode: List<ItemListModel>,
    ) : DetailState
    data class Error(val message: String) : DetailState
}