package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsymbaliuk.currency.converter.android.R
import com.tsymbaliuk.currency.converter.android.ui.theme.AppColors
import com.tsymbaliuk.currency.converter.android.ui.theme.AppShapes
import com.tsymbaliuk.currency.converter.android.ui.theme.Black
import com.tsymbaliuk.currency.converter.android.ui.theme.paddingMedium

@Preview
@Composable
fun SwapButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(paddingMedium)
            .width(120.dp)
            .height(48.dp)
            .clip(AppShapes.medium)
            .background(AppColors.secondary)
            .clickable { }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_round_swap_vert_24),
            contentDescription = stringResource(id = R.string.swap),
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            tint = Black
        )
    }
}