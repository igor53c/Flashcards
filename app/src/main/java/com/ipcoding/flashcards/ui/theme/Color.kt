package com.ipcoding.flashcards.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Green10 = Color(0xFF03D87F)
val Blue100 = Color(0xFF00A8EA)
val Gray10 = Color(0xFF9B9B9B)
val Yellow10 = Color(0xFFFFC800)
val Red10 = Color(0xFFF4511E)
val Red20 = Color(0xFFD81B60)

object Colors {
    val Blue = Blue100
    val Yellow = Yellow10
    val Green = Green10
    val Error = Red20
    val Red = Red10
    val Gray = Gray10
}

fun lightAppColors(
    primary: Color = Yellow10,
    primaryVariant: Color = Color(0xFF3700B3),
    secondary: Color = Gray10,
    secondaryVariant: Color = Green10,
    background: Color = Color.White,
    surface: Color = Color.White,
    error: Color = Color(0xFFB00020),
    onPrimary: Color = Color.White,
    onSecondary: Color = Color.Black,
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.White
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
    true
)

fun darkAppColors(
    primary: Color = Yellow10,
    primaryVariant: Color = Color(0xFF3700B3),
    secondary: Color = Gray10,
    secondaryVariant: Color = Green10,
    background: Color = Color(0xFF121212),
    surface: Color = Color(0xFF121212),
    error: Color = Color(0xFFCF6679),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    onBackground: Color = Color.White,
    onSurface: Color = Color.White,
    onError: Color = Color.Black
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
    false
)

val DarkAppColorPalette = darkAppColors()

val LightAppColorPalette = lightAppColors()

val LocalAppColors = staticCompositionLocalOf { LightAppColorPalette }