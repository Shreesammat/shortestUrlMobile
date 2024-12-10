package com.example.myapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


// Define your custom colors
val NeonGreen = Color(0xFF00FF00)
val NeonPink = Color(0xFFFF00FF)
val NeonCyan = Color(0xFF00FFFF)
val BlackColor = Color(0xFF000000)
val DarkGrayColor = Color(0xFF121212)

// Define Material 3 color schemes
val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    secondary = NeonPink,
    background = BlackColor,
    surface = DarkGrayColor,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

val LightColorScheme = lightColorScheme(
    primary = NeonGreen,
    secondary = NeonPink,
    background = Color.White,
    surface = Color.LightGray,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)
