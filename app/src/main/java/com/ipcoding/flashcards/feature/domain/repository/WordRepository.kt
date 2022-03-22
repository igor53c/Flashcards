package com.ipcoding.flashcards.feature.domain.repository

import com.ipcoding.flashcards.feature.domain.model.Word

interface WordRepository {

    suspend fun insertWord(word: Word)

    suspend fun deleteWord(word: Word)

    suspend fun getWords(): List<Word>
}