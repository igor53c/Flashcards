package com.ipcoding.flashcards.feature.domain.use_case

data class AllUseCases (
    val createDatabase: CreateDatabase,
    val getRandomWord: GetRandomWord,
    val stringInUnderscores: StringInUnderscores,
    val typeLetter: TypeLetter
)