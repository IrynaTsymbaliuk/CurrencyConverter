package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.tsymbaliuk.currency.converter.android.ui.theme.AppShapes
import com.tsymbaliuk.currency.converter.android.ui.theme.GreyLight

@Preview
@Composable
fun FrontLayerContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(AppShapes.large)
            .background(GreyLight)
    ) {
        CurrencyRow(modifier = Modifier)
    }

}