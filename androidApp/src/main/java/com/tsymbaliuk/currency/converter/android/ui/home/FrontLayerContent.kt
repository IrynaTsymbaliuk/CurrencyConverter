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
import com.tsymbaliuk.currency.converter.model.Currency

@Composable
fun FrontLayerContent(
    modifier: Modifier = Modifier,
    selectedToCurrency: Currency?,
    currencyList: List<Currency>,
    onToCurrencySelect: (Currency) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(AppShapes.large)
            .background(GreyLight)
    ) {
        CurrencyRow(
            selectedCurrency = selectedToCurrency,
            currencyList = currencyList,
            onCurrencySelect = { onToCurrencySelect(it) })
    }
}

@Preview
@Composable
private fun FrontLayerContentPreview() {
    FrontLayerContent(
        selectedToCurrency = null,
        currencyList = emptyList(),
        onToCurrencySelect = { }
    )
}
