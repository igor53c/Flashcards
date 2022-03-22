package com.ipcoding.flashcards.feature.presentation.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ipcoding.flashcards.ui.theme.AppTheme
import com.ipcoding.flashcards.R
import com.ipcoding.flashcards.feature.presentation.util.Screen

@Composable
fun StartScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate(Screen.GameScreen.route) },
            shape = AppTheme.customShapes.roundedCornerShapeMedium,
            colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary)
        ) {
            Text(
                text = stringResource(id = R.string.play),
                style = AppTheme.typography.h1,
                color = AppTheme.colors.background
            )
        }
    }
}