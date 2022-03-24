package com.ipcoding.flashcards.feature.presentation.start

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.flashcards.ui.theme.AppTheme
import com.ipcoding.flashcards.R
import com.ipcoding.flashcards.feature.presentation.start.components.IconsRow
import com.ipcoding.flashcards.feature.presentation.util.Screen

@Composable
fun StartScreen(
    navController: NavController,
    viewModel: StartViewModel = hiltViewModel(),
    onChangeThemeClick: () -> Unit
) {
    val isDatabaseReady = viewModel.isDatabaseReady.value
    val isDarkTheme = viewModel.isDarkTheme.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconsRow(
            onChangeThemeClick = {
                viewModel.saveIsDarkTheme()
                onChangeThemeClick()
            },
            isDarkTheme = isDarkTheme
        )
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    if(isDatabaseReady)
                        navController.navigate(Screen.GameScreen.route)
                },
                shape = AppTheme.customShapes.roundedCornerShapeMedium,
                colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary)
            ) {
                Text(
                    text = stringResource(id = R.string.translate_word),
                    style = AppTheme.typography.h2,
                    color = AppTheme.colors.background
                )
            }
        }
    }
}