package com.plcoding.cryptotracker.cripto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto (
    val data: List<CoinDto>

)