package com.example.mynutri_app.ui.theme

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFF33EE66)
val SecondaryColor = Color(0xFF122932)
val TerciaryColor = Color(0xFFFFFFFF)
val ColorForGradient = Color(0xFF6ED863)
val GradientColor = Modifier.background(
    brush = Brush.radialGradient(
        colors = listOf(PrimaryColor, ColorForGradient),
        radius = 100f
    )
)

/*
    Criar as cores para o tema escuro
 */