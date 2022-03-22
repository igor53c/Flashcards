package com.ipcoding.flashcards.feature.presentation.game

import androidx.lifecycle.ViewModel
import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val allUseCases: AllUseCases
)  : ViewModel() {

}