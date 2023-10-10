package com.rafelis1997.minhasreceitasapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias PrepareModeDomain = PrepareMode

@Entity
data class PrepareMode(
    val id: Int = 0,
    val name: String,
    val idRecipe: Int,
)