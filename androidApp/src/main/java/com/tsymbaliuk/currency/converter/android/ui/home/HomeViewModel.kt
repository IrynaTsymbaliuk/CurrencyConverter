package com.tsymbaliuk.currency.converter.android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsymbaliuk.currency.converter.android.home.HomeIntent
import com.tsymbaliuk.currency.converter.android.home.HomeState
import com.tsymbaliuk.currency.converter.android.mvi.base.MviViewModel
import com.tsymbaliuk.currency.converter.model.Currency
import com.tsymbaliuk.currency.converter.usecase.UseCaseProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCaseProvider: UseCaseProvider,
) : ViewModel(), MviViewModel<HomeIntent, HomeState> {

    val userIntent = Channel<HomeIntent>(Channel.UNLIMITED)

    private val _uiStateStream: MutableStateFlow<HomeState> =
        MutableStateFlow(
            HomeState(
                isLoading = true,
                fromCurrency = null,
                toCurrency = null
            )
        )
    override val uiStateStream: StateFlow<HomeState>
        get() = _uiStateStream


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect { intent ->
                when (intent) {
                    is HomeIntent.GetCurrencyList -> getCurrencyList()
                    is HomeIntent.SelectFromCurrency -> selectFromCurrency(intent.currency)
                    is HomeIntent.Swap -> swap()
                    is HomeIntent.SelectToCurrency -> selectToCurrency(intent.currency)
                }
            }
        }
    }

    private fun getCurrencyList() {
        viewModelScope.launch {
            _uiStateStream.emit(_uiStateStream.value.copy(isLoading = true))
            val currencyList = useCaseProvider.getCurrencyList()
            if (currencyList.isNotEmpty()) {
                _uiStateStream.emit(_uiStateStream.value.copy(currencyList = currencyList))
            }
            _uiStateStream.emit(_uiStateStream.value.copy(isLoading = false))
        }
    }

    private fun selectFromCurrency(selected: Currency) {
        viewModelScope.launch {
            _uiStateStream.emit(_uiStateStream.value.copy(fromCurrency = selected))
        }
    }

    private fun swap() {
        viewModelScope.launch {
            val from = _uiStateStream.value.fromCurrency
            val to = _uiStateStream.value.toCurrency
            _uiStateStream.emit(_uiStateStream.value.copy(fromCurrency = to, toCurrency = from))
        }
    }

    private fun selectToCurrency(selected: Currency) {
        viewModelScope.launch {
            _uiStateStream.emit(_uiStateStream.value.copy(toCurrency = selected))
        }
    }

}