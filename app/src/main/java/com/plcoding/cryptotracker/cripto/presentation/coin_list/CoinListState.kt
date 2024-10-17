package com.plcoding.cryptotracker.cripto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.cripto.presentation.models.CoinUI

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null,
)
