package com.example.smart_campus_companion.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryGold,
    background = BackgroundGray,
    surface = SurfaceWhite,
    onPrimary = SurfaceWhite, // Sets text on buttons to white
    onSurface = Color(0xFF212121) // Sets main text color
)

@Composable
fun Smart_Campus_CompanionTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}