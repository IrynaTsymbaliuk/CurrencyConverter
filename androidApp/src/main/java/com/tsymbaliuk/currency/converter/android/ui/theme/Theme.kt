package com.tsymbaliuk.currency.converter.android.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColors,
        shapes = AppShapes,
        typography = AppTypography,
        content = content
    )
}