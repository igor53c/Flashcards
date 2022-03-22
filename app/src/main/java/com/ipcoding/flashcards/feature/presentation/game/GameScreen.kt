package com.ipcoding.flashcards.feature.presentation.game

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.flashcards.feature.presentation.game.components.Keyboard
import com.ipcoding.flashcards.ui.theme.AppTheme

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val randomWord = viewModel.randomWord.value
    val translation = viewModel.translation.value
    val defaultDimension = AppTheme.dimensions.default
    val maxWidth = remember { mutableStateOf(defaultDimension) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = AppTheme.dimensions.spaceSmall,
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = AppTheme.dimensions.spaceSmall),
            contentAlignment = Alignment.TopCenter
        ) {
            maxWidth.value = this.maxWidth

            Column( modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = randomWord.serbianWord,
                        style = AppTheme.typography.h1,
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
                        style = AppTheme.typography.h1,
                        color = AppTheme.colors.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Keyboard(maxWidth = maxWidth.value)
            }
        }
    }
}