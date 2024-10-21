package com.plcoding.cryptotracker.cripto.presentation.coin_list

import com.plcoding.cryptotracker.cripto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
   // data object OnRefresh : CoinListAction
}