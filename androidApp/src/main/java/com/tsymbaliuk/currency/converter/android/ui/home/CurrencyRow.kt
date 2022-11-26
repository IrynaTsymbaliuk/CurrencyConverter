@file:OptIn(ExperimentalMaterial3Api::class)

package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsymbaliuk.currency.converter.android.R
import com.tsymbaliuk.currency.converter.android.ui.theme.*
import com.tsymbaliuk.currency.converter.model.Currency

@Composable
fun CurrencyRow(
    modifier: Modifier = Modifier,
    selectedCurrency: Currency?,
    currencyList: List<Currency>,
    onCurrencySelect: (Currency) -> Unit
) {
    Row(
        modifier = modifier.padding(paddingMedium),
        horizontalArrangement = Arrangement.spacedBy(paddingSmall)
    ) {
        CurrencyCode(
            modifier = Modifier.weight(1f),
            selectedCurrency = selectedCurrency,
            currencyList = currencyList,
            onCurrencySelect = onCurrencySelect
        )
        Amount(
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
private fun CurrencyCode(
    modifier: Modifier = Modifier,
    selectedCurrency: Currency?,
    currencyList: List<Currency>,
    onCurrencySelect: (Currency) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clickable { expanded = !expanded }
    ) {

        Text(
            text = stringResource(id = R.string.currency_code),
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingExtraSmall),
            color = AppColors.onSecondary,
            style = AppTypography.labelMedium,
            textAlign = TextAlign.Start
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(64.dp)
                .clip(AppShapes.medium)
                .background(AppColors.primaryContainer),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically),
                style = AppTypography.bodyLarge,
                text = selectedCurrency?.code ?: "",
                color = AppColors.onPrimary
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id = if (expanded) R.string.close else R.string.expand),
                modifier = Modifier
                    .rotate(if (expanded) 0f else 180f)
                    .align(Alignment.CenterVertically),
                tint = AppColors.onPrimary
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                currencyList.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            onCurrencySelect(selectionOption)
                        },
                        text = { Text(text = selectionOption.code) }
                    )
                }
            }
        }
    }
}

@Composable
private fun Amount(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.amount),
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingExtraSmall),
            color = AppColors.onSecondary,
            style = AppTypography.labelMedium,
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(
                    color = AppColors.primaryContainer,
                    shape = AppShapes.medium
                )
        ) {
            val amountValue = remember { mutableStateOf(TextFieldValue("4.50")) }
            OutlinedTextField(
                value = amountValue.value,
                onValueChange = { amountValue.value = it },
                modifier = Modifier.fillMaxSize(),
                textStyle = AppTypography.bodyLarge,
                leadingIcon = {
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        style = AppTypography.bodyLarge,
                        text = "$",
                        color = AppColors.onPrimary
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = AppColors.onPrimary,
                    containerColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }
}

@Preview
@Composable
private fun CurrencyRowPreview() {
    CurrencyRow(
        selectedCurrency = null,
        currencyList = emptyList(),
        onCurrencySelect = { }
    )
}

@Preview
@Composable
private fun CurrencyCodePreview() {
    CurrencyCode(
        selectedCurrency = null,
        currencyList = emptyList(),
        onCurrencySelect = { }
    )
}

@Preview
@Composable
private fun AmountPreview() {
    Amount()
}