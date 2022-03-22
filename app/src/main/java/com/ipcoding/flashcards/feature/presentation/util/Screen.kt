package com.ipcoding.flashcards.feature.presentation.util

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
    object StartScreen : Screen("start_screen")
}
