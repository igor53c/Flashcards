package com.ipcoding.flashcards.feature.presentation.game

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.flashcards.R
import com.ipcoding.flashcards.feature.presentation.game.components.Keyboard
import com.ipcoding.flashcards.feature.presentation.game.components.Words
import com.ipcoding.flashcards.feature.presentation.util.Screen
import com.ipcoding.flashcards.ui.theme.AppTheme

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val defaultDimension = AppTheme.dimensions.default
    val maxWidth = remember { mutableStateOf(defaultDimension) }
    val notNextWord = remember { mutableStateOf(true) }

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

                Words(modifier = Modifier.weight(1f))

                Button(
                    onClick = {
                        if(notNextWord.value) {
                            viewModel.showAnswer()
                            notNextWord.value = false
                        } else navController.navigate(Screen.GameScreen.route)
                    },
                    shape = AppTheme.customShapes.roundedCornerShapeSmall,
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if(notNextWord.value)
                            stringResource(id = R.string.show_answer) else
                            stringResource(id = R.string.next_word),
                        style = AppTheme.typography.h6,
                        color = AppTheme.colors.background
                    )
                }

                Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))

                Keyboard(
                    maxWidth = maxWidth.value,
                    onLetterClick = {
                        if(notNextWord.value)
                            viewModel.typeLetter(it)
                    },
                    onEnterClick = {
                        if(notNextWord.value && viewModel.checkIfWordIsCorrect())
                            notNextWord.value = false
                    }
                )
            }
        }
    }
}