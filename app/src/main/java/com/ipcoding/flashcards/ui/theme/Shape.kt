package com.ipcoding.flashcards.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val SmallShapes = CustomShapes(
    roundedCornerShapeSmall = RoundedCornerShape(6.dp),
    roundedCornerShapeMedium = RoundedCornerShape(12.dp)
)

val NormalShapes = CustomShapes(
    roundedCornerShapeSmall = RoundedCornerShape(8.dp),
    roundedCornerShapeMedium = RoundedCornerShape(16.dp)
)

val LargeShapes = CustomShapes(
    roundedCornerShapeSmall = RoundedCornerShape(12.dp),
    roundedCornerShapeMedium = RoundedCornerShape(24.dp)
)

val ExtraLargeShapes = CustomShapes(
    roundedCornerShapeSmall = RoundedCornerShape(16.dp),
    roundedCornerShapeMedium = RoundedCornerShape(32.dp)
)

@Immutable
class CustomShapes(
    val roundedCornerShapeSmall: CornerBasedShape = RoundedCornerShape(8.dp),
    val roundedCornerShapeMedium: CornerBasedShape = RoundedCornerShape(16.dp)
)

val LocalAppShapes = staticCompositionLocalOf { NormalShapes }