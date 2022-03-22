package com.ipcoding.flashcards.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
    var primaryVariant by mutableStateOf(primaryVariant)
    var secondary by mutableStateOf(secondary)
    var secondaryVariant by mutableStateOf(secondaryVariant)
    var background by mutableStateOf(background)
    var surface by mutableStateOf(surface)
    var error by mutableStateOf(error)
    var onPrimary by mutableStateOf(onPrimary)
    var onSecondary by mutableStateOf(onSecondary)
    var onBackground by mutableStateOf(onBackground)
    var onSurface by mutableStateOf(onSurface)
    var onError by mutableStateOf(onError)
    var isLight by mutableStateOf(isLight)

    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        secondary: Color = this.secondary,
        secondaryVariant: Color = this.secondaryVariant,
        background: Color = this.background,
        surface: Color = this.surface,
        error: Color = this.error,
        onPrimary: Color = this.onPrimary,
        onSecondary: Color = this.onSecondary,
        onBackground: Color = this.onBackground,
        onSurface: Color = this.onSurface,
        onError: Color = this.onError,
        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        secondaryVariant = other.secondaryVariant
        background = other.background
        surface = other.surface
        error = other.error
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        onSurface = other.onSurface
        onError = other.onError
    }
}