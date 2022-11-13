package com.tsymbaliuk.currency.converter.android.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Green = Color(0xFF006064)
val GreenLight = Color(0xFF428e92)
val GreenDark = Color(0xFF00363A)

val Grey = Color(0xFFEEEEEE)
val GreyLight = Color(0xFFFFFFFF)
val GreyDark = Color(0xFFBCBCBC)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val AppColors = lightColorScheme(
    primary = Green,
    primaryContainer = GreenDark,
    secondary = Grey,
    secondaryContainer = GreyLight,
    onPrimary = White,
    onSecondary = Black
)