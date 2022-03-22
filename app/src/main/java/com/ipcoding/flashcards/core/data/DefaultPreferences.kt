package com.ipcoding.flashcards.core.data

import android.content.SharedPreferences
import com.ipcoding.flashcards.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveIsBeginning(isBeginning: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(Preferences.IS_BEGINNING, isBeginning)
            .apply()
    }

    override fun loadIsBeginning(): Boolean {
        return sharedPreferences.getBoolean(Preferences.IS_BEGINNING, true)
    }
}