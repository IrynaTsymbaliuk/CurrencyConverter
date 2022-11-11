package com.tsymbaliuk.currency.converter.android.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Red = Color(0xFFB71C1C)
val RedLight = Color(0xFFF05545)
val RedDark = Color(0xFF7F0000)

val Grey = Color(0xFFFAFAFA)
val GreyLight = Color(0xFFFFFFFF)
val GreyDark = Color(0xFFC7C7C7)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val AppColors = lightColors(
    primary = Red,
    primaryVariant = RedDark,
    secondary = Grey,
    secondaryVariant = GreyDark,
    onPrimary = White,
    onSecondary = Black
)