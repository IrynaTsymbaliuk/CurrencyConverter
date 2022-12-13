package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.tsymbaliuk.currency.converter.android.home.HomeIntent
import com.tsymbaliuk.currency.converter.android.ui.composable.component.ProgressBar
import com.tsymbaliuk.currency.converter.android.ui.theme.AppColors
import com.tsymbaliuk.currency.converter.model.Currency
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Preview
@Composable
fun HomeScreen() {

    val viewModel = getViewModel<HomeViewModel>()
    val state by viewModel.uiStateStream.collectAsState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = "HomeScreen", block = {
        onScreenLaunch(scope, viewModel)
    })

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.primary)
    ) {
        val (backLayer, swapButton, frontLayer) = createRefs()
        val middleGuideline = createGuidelineFromTop(0.5f)

        BackLayerContent(
            modifier = Modifier
                .constrainAs(
                    ref = backLayer,
                    constrainBlock = {
                        height = Dimension.fillToConstraints
                        width = Dimension.matchParent
                        top.linkTo(parent.top)
                        bottom.linkTo(middleGuideline)
                    }),
            selectedFromCurrency = state.fromCurrency,
            currencyList = state.currencyList,
            onFromCurrencySelect = { onFromCurrencySelected(scope, viewModel, it) }
        )

        FrontLayerContent(
            modifier = Modifier
                .constrainAs(
                    ref = frontLayer,
                    constrainBlock = {
                        height = Dimension.fillToConstraints
                        width = Dimension.matchParent
                        top.linkTo(middleGuideline)
                        bottom.linkTo(parent.bottom)
                    }),
            selectedToCurrency = state.toCurrency,
            currencyList = state.currencyList,
            onToCurrencySelect = { onToCurrencySelected(scope, viewModel, it) }
        )

        SwapButton(
            modifier = Modifier
                .constrainAs(
                    ref = swapButton,
                    constrainBlock = {
                        top.linkTo(middleGuideline)
                        end.linkTo(parent.end)
                        bottom.linkTo(middleGuideline)
                    }
                ),
            swap = { onSwapButtonClick(scope, viewModel) }
        )

        if (state.isLoading) {
            ProgressBar()
        }
    }

}

private fun onScreenLaunch(
    scope: CoroutineScope,
    viewModel: HomeViewModel,
) {
    scope.launch {
        viewModel.userIntent.send(HomeIntent.GetCurrencyList)
    }
}

private fun onFromCurrencySelected(
    scope: CoroutineScope,
    viewModel: HomeViewModel,
    item: Currency,
) {
    scope.launch { viewModel.userIntent.send(HomeIntent.SelectFromCurrency(item)) }
}

private fun onSwapButtonClick(
    scope: CoroutineScope,
    viewModel: HomeViewModel,
) {
    scope.launch { viewModel.userIntent.send(HomeIntent.Swap) }
}

private fun onToCurrencySelected(
    scope: CoroutineScope,
    viewModel: HomeViewModel,
    item: Currency,
) {
    scope.launch { viewModel.userIntent.send(HomeIntent.SelectToCurrency(item)) }
}