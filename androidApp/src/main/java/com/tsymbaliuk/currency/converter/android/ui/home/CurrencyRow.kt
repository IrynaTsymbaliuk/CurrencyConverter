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

@Preview
@Composable
fun CurrencyRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(paddingMedium),
        horizontalArrangement = Arrangement.spacedBy(paddingSmall)
    ) {
        CountryCode(modifier = Modifier.weight(1f))
        Amount(modifier = Modifier.weight(2f))
    }
}

@Preview
@Composable
private fun CountryCode(
    modifier: Modifier = Modifier,
    items: List<String> = testCountryCodeList
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.country_code),
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingExtraSmall),
            color = Black,
            style = AppTypography.labelMedium,
            textAlign = TextAlign.Start
        )

        var selectedIndex by remember { mutableStateOf(0) }
        var expanded by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(AppShapes.medium)
                .background(AppColors.primaryContainer)
                .align(Alignment.CenterHorizontally)
                .clickable { expanded = !expanded },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically),
                style = AppTypography.bodyLarge,
                text = items[selectedIndex],
                color = White
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .rotate(if (expanded) 180f else 0f),
                tint = AppColors.onPrimary
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                items.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndex = items.indexOf(selectionOption)
                            expanded = false
                        },
                        text = { Text(text = selectionOption) }
                    )
                }
            }
        }
    }
}

@Preview
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
                        text = "$",
                        color = AppColors.onPrimary,
                        style = AppTypography.bodyLarge
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

private val testCountryCodeList =
    listOf(
        "ALL",
        "AFN",
        "ARS",
        "AWG",
        "AUD",
        "AZN"
    )