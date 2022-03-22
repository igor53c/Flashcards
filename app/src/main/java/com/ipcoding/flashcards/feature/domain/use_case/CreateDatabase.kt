package com.ipcoding.flashcards.feature.domain.use_case

import com.ipcoding.flashcards.core.domain.preferences.Preferences
import com.ipcoding.flashcards.core.util.Words1
import com.ipcoding.flashcards.feature.domain.repository.WordRepository

class CreateDatabase(
    private val wordRepository: WordRepository,
    private val preferences: Preferences
) {

    suspend operator fun invoke(): Boolean {

        wordRepository.deleteAll()

        for (word in Words1.WORDS_1) {
            wordRepository.insertWord(word)
        }

        preferences.saveIsBeginning(false)

        return true
    }
}