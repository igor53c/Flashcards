package com.ipcoding.flashcards.feature.presentation.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.flashcards.core.util.Constants.DURATION_COLOR_ANIMATION
import com.ipcoding.flashcards.feature.domain.model.Word
import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import com.ipcoding.flashcards.ui.theme.Colors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    private var _translationColor = mutableStateOf(Colors.Blue)
    val translationColor: State<Color> = _translationColor

    init {
        getRandomWord()
    }

    private fun getRandomWord() {
        val waitJob = viewModelScope.launch {
            _randomWord.value = allUseCases.getRandomWord()
        }
        viewModelScope.launch {
            waitJob.join()
            _translation.value =
                allUseCases.stringInUnderscores(randomWord.value.germanTranslation)
        }
    }

    fun typeLetter(letter: String) {
        _translation.value = allUseCases.typeLetter(letter, translation.value)
    }

    fun checkIfWordIsCorrect() : Boolean {
        return if(translation.value == randomWord.value.germanTranslation.uppercase()) true else {
            changeTranslationColor()
            false
        }
    }

    private fun changeTranslationColor() {
        _translationColor.value = Colors.Error
        val waitJob = viewModelScope.launch {
            delay(DURATION_COLOR_ANIMATION.toLong())
        }
        viewModelScope.launch {
            waitJob.join()
            _translationColor.value = Colors.Blue
        }
    }
}