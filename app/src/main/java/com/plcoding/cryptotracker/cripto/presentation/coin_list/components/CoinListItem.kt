package com.plcoding.cryptotracker.cripto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.cripto.domain.Coin
import com.plcoding.cryptotracker.cripto.presentation.models.CoinUi
import com.plcoding.cryptotracker.cripto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CoinListItem(coinUI: CoinUi, onClick: () -> Unit, modifier: Modifier = Modifier) {
val contentColor = if(isSystemInDarkTheme()){
    Color.White
}else{
    Color.Black
}

    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUI.iconRes),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column(modifier= Modifier.weight(1f)) {
            Text(text = coinUI.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(text = coinUI.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "${coinUI.priceUsd.formatted}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            PriceChange(change = coinUI.changePercent24Hr)
        }
    }
}


@PreviewLightDark
@Composable
private fun CoinListItemPreview() {
    CryptoTrackerTheme {
        CoinListItem(coinUI = previewCoin,
            onClick = {/*TODO*/ },
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        )
    }

}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 19254554545.54,
    priceUsd = 625321.89,
    changePercent24Hr = 0.1,

).toCoinUI()

fun Coin.toCoinUI():CoinUi{
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = priceUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol),
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getCurrencyInstance(Locale.US).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )

}