package com.ipcoding.flashcards.feature.domain.use_case

import com.ipcoding.flashcards.feature.domain.model.Word
import com.ipcoding.flashcards.feature.domain.repository.WordRepository

class GetRandomWord(
    private val wordRepository: WordRepository
) {

    suspend operator fun invoke(): Word {
        return wordRepository.getWords(0).random()
    }
}