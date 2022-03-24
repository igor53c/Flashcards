package com.ipcoding.flashcards.core.domain.preferences

interface Preferences {

    fun saveIsBeginning (isBeginning: Boolean)
    fun loadIsBeginning(): Boolean

    fun saveIsDarkTheme(isDarkTheme: Boolean)
    fun loadIsDarkTheme(): Boolean

    companion object {
        const val IS_BEGINNING = "is_beginning"
        const val IS_DARK_THEME = "is_dark_theme"
    }
}