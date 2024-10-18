package com.plcoding.cryptotracker.cripto.presentation.coin_list

import com.plcoding.cryptotracker.cripto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(val coin: CoinUI) : CoinListAction
   // data object OnRefresh : CoinListAction
}