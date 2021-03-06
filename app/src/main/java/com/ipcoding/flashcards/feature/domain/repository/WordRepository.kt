package com.ipcoding.flashcards.feature.domain.repository

import com.ipcoding.flashcards.feature.domain.model.Word

interface WordRepository {

    suspend fun insertWord(word: Word)

    suspend fun deleteWord(word: Word)

    suspend fun deleteAll()

    suspend fun getWords(numberOfHits: Int): List<Word>
}