package com.tsymbaliuk.currency.converter.android.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    small = RoundedCornerShape(percent = 50),
    medium = RoundedCornerShape(size = 16.dp),
    large = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
)