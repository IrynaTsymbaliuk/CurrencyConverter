package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tsymbaliuk.currency.converter.android.R
import com.tsymbaliuk.currency.converter.android.ui.theme.AppColors
import com.tsymbaliuk.currency.converter.android.ui.theme.AppTypography
import com.tsymbaliuk.currency.converter.android.ui.theme.paddingMedium
import com.tsymbaliuk.currency.converter.model.Currency

@Composable
fun BackLayerContent(
    modifier: Modifier = Modifier,
    selectedFromCurrency: Currency?,
    currencyList: List<Currency>,
    onFromCurrencySelect: (Currency) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.primary),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier.padding(paddingMedium),
            text = stringResource(id = R.string.currency_converter),
            color = AppColors.secondary,
            style = AppTypography.displaySmall
        )
        CurrencyRow(
            selectedCurrency = selectedFromCurrency,
            currencyList = currencyList,
            onCurrencySelect = { onFromCurrencySelect(it) }
        )
    }
}

@Preview
@Composable
private fun BackLayerContentPreview() {
    BackLayerContent(
        selectedFromCurrency = null,
        currencyList = emptyList(),
        onFromCurrencySelect = {}
    )
}

