package com.plcoding.cryptotracker.cripto.data.mappers

import com.plcoding.cryptotracker.cripto.data.networking.dto.CoinDto
import com.plcoding.cryptotracker.cripto.data.networking.dto.CoinPriceDto
import com.plcoding.cryptotracker.cripto.domain.Coin
import com.plcoding.cryptotracker.cripto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

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

fun CoinPriceDto.toCoinPrice():CoinPrice{
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochMilli(time).atZone(ZoneId.of("UTC"))
    )

}