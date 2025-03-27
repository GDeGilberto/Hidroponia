package com.inercy.hidroponia.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.R
import com.inercy.hidroponia.ui.models.TypeOfMeasurement
import com.inercy.hidroponia.ui.theme.BlueDarker
import com.inercy.hidroponia.ui.theme.BlueSubtle
import com.inercy.hidroponia.ui.theme.DarkDarker
import com.inercy.hidroponia.ui.theme.LightBase
import com.inercy.hidroponia.ui.theme.RedDarker
import com.inercy.hidroponia.ui.theme.RedSubtle
import com.inercy.hidroponia.ui.theme.YellowDarker
import com.inercy.hidroponia.ui.theme.YellowSubtle
import kotlin.String

@Preview
@Composable
fun MonitorWeather(
    lightValue: Int = 0,
    temperatureValue: Int = 0,
    humidityValue: Int = 0,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(color = LightBase)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ItemParameter(
            icon = R.drawable.sun,
            iconTint = YellowDarker,
            backgroundColor = YellowSubtle,
            text = stringResource(R.string.luminosidad),
            description = "$lightValue ${TypeOfMeasurement.LIGHT_INTENSITY.symbol}"
        )
        ItemParameter(
            icon = R.drawable.temp,
            iconTint = RedDarker,
            backgroundColor = RedSubtle,
            text = stringResource(R.string.temp),
            description = "$temperatureValue${TypeOfMeasurement.TEMPERATURE.symbol}"
        )
        ItemParameter(
            icon = R.drawable.humidity_indoor,
            iconTint = BlueDarker,
            backgroundColor = BlueSubtle,
            text = stringResource(R.string.humidity),
            description = "$humidityValue${TypeOfMeasurement.HUMIDITY.symbol}"
        )
    }
}

@Composable
fun ItemParameter(
    @DrawableRes icon: Int,
    iconTint: Color,
    backgroundColor: Color,
    text: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .size(32.dp)
                .background(
                    color = backgroundColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                contentDescription = description,
                painter = painterResource(id = icon),
                modifier = modifier.size(20.dp),
                tint = iconTint
            )
        }

        Column(
            modifier = modifier.padding(start = 4.dp)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
                color = DarkDarker
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}