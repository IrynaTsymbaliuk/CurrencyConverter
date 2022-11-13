package com.tsymbaliuk.currency.converter.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tsymbaliuk.currency.converter.android.R

val Montserrat = FontFamily(
    Font(resId = R.font.montserrat_light, weight = FontWeight.Light),
    Font(resId = R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(resId = R.font.montserrat_bold, weight = FontWeight.Bold)
)
val Sora = FontFamily(
    Font(resId = R.font.sora_regular, weight = FontWeight.Normal),
    Font(resId = R.font.sora_medium, weight = FontWeight.Medium)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 97.sp,
        fontWeight = FontWeight.Light,
        fontFamily = Montserrat,
        letterSpacing = (-1.5).sp
    ),
    displayMedium = TextStyle(
        fontSize = 61.sp,
        fontWeight = FontWeight.Light,
        fontFamily = Montserrat,
        letterSpacing = (-0.5).sp
    ),
    displaySmall = TextStyle(
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Montserrat,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Montserrat,
        letterSpacing = 0.25.sp
    ),
    headlineMedium = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Montserrat,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Montserrat,
        letterSpacing = 0.15.sp
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Montserrat,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Montserrat,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Sora,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Sora,
        letterSpacing = 0.25.sp
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Sora,
        letterSpacing = 1.25.sp
    ),
    labelMedium = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Sora,
        letterSpacing = 0.4.sp
    ),
    labelSmall = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Sora,
        letterSpacing = 1.5.sp
    )
)