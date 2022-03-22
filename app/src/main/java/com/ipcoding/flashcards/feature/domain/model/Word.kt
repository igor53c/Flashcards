package com.ipcoding.flashcards.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word (
    val serbianWord : String,
    val germanTranslation: String,
    val numberOfHits: Int = 0,
    @PrimaryKey var id: Int? = null
)