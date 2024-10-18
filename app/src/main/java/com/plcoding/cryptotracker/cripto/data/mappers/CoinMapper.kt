package com.plcoding.cryptotracker.cripto.data.mappers

import com.plcoding.cryptotracker.cripto.data.networking.dto.CoinDto
import com.plcoding.cryptotracker.cripto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )

}