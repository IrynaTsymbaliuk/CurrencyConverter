package com.tsymbaliuk.currency.converter.android.mvi.base

import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<in I : ViewIntent, out S : ViewState> {
    val uiStateStream: StateFlow<ViewState>
}