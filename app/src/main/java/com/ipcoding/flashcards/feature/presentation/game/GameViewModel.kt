package com.ipcoding.flashcards.feature.presentation.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.flashcards.feature.domain.model.Word
import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val allUseCases: AllUseCases
)  : ViewModel() {

    private var _randomWord = mutableStateOf(Word("",""))
    val randomWord: State<Word> = _randomWord

    private var _translation = mutableStateOf("")
    val translation: State<String> = _translation

    init {
        getRandomWord()
    }

    private fun getRandomWord() {
        val waitJob = viewModelScope.launch {
            _randomWord.value = allUseCases.getRandomWord()
        }
        viewModelScope.launch {
            waitJob.join()
            _translation.value = randomWord.value.germanTranslation
        }
    }
}