package com.ipcoding.flashcards.feature.presentation.game.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.flashcards.core.util.Constants
import com.ipcoding.flashcards.feature.presentation.game.GameViewModel
import com.ipcoding.flashcards.ui.theme.AppTheme

@Composable
fun Words(
    modifier : Modifier = Modifier,
    viewModel: GameViewModel = hiltViewModel()
) {
    val randomWord = viewModel.randomWord.value
    val translation = viewModel.translation.value
    val translationColor = viewModel.translationColor.value
    val color = animateColorAsState(
        targetValue = translationColor,
        animationSpec = tween(Constants.DURATION_COLOR_ANIMATION)
    ).value
    Column(modifier = modifier) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = randomWord.serbianWord,
                style = AppTheme.typography.h2,
                color = AppTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = translation,
                style = AppTheme.typography.h2,
                color = color,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}