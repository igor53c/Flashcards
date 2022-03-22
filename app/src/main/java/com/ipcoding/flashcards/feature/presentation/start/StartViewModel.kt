package com.ipcoding.flashcards.feature.presentation.start

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.flashcards.core.domain.preferences.Preferences
import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val allUseCases: AllUseCases,
    private val preferences: Preferences
) : ViewModel() {

    private var _isDatabaseReady = mutableStateOf(false)
    val isDatabaseReady: State<Boolean> = _isDatabaseReady

    init {
        loadIsBeginning()
    }

    private fun loadIsBeginning() {
        if(preferences.loadIsBeginning())
            createDatabase() else _isDatabaseReady.value = true
    }

    private fun createDatabase() {
        viewModelScope.launch {
            _isDatabaseReady.value = allUseCases.createDatabase()
        }
    }
}