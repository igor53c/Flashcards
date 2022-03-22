package com.ipcoding.flashcards.feature.data.repository

import com.ipcoding.flashcards.feature.data.data_source.WordDao
import com.ipcoding.flashcards.feature.domain.model.Word
import com.ipcoding.flashcards.feature.domain.repository.WordRepository

class WordRepositoryImpl(
    private val dao: WordDao
) : WordRepository {

    override suspend fun insertWord(word: Word) {
        dao.insertWord(word)
    }

    override suspend fun deleteWord(word: Word) {
        dao.deleteWord(word)
    }

    override suspend fun getWords(): List<Word> {
        return dao.getWords()
    }
}