package com.ipcoding.flashcards.core.domain.preferences

interface Preferences {

    fun saveIsBeginning (isBeginning: Boolean)
    fun loadIsBeginning(): Boolean

    companion object {
        const val IS_BEGINNING = "is_beginning"
    }
}