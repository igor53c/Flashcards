package com.ipcoding.flashcards.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ipcoding.flashcards.feature.presentation.game.GameScreen
import com.ipcoding.flashcards.feature.presentation.start.StartScreen
import com.ipcoding.flashcards.feature.presentation.util.Screen
import com.ipcoding.flashcards.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val isStatusBarVisibleLiveData = MutableLiveData(false)

    override fun onResume() {
        super.onResume()
        isStatusBarVisibleLiveData.value = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            systemUiController.isStatusBarVisible = false

            isStatusBarVisibleLiveData.observeForever {
                systemUiController.isStatusBarVisible = it
            }
            AppTheme {
                Surface(
                    color = AppTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.StartScreen.route
                    ) {
                        composable(route = Screen.GameScreen.route) {
                            GameScreen()
                        }
                        composable(route = Screen.StartScreen.route) {
                            StartScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}